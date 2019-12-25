package come.glasses.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import come.glasses.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Objects;

/**
 * @Description : null.java
 * @auther : modan
 * @create : 2019-12-24 10:40
 */
@Component
public class JwtTokenUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);
    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";
    @Value("${jwt.secret}")
    private String secret;

    private static Long EXPIRATION;

    @Value("${jwt.expiration}")
    public void setExpiration(Long expiration) {
        EXPIRATION = expiration;
    }

    /**
     * 生成token
     *
     * @param userId   从数据库中查询出来的用户信息 #{user.id}
     * @param password 从数据库中查询出来的用户信息 #{user.password}
     * @return 新的token
     */
    public static String generateToken(Integer userId, String password) {
        Date date = new Date(System.currentTimeMillis() + EXPIRATION);
        try {
            return JWT.create()
                    .withAudience(userId.toString())          // 将 user id 保存到 token 里面
                    .withExpiresAt(date)
                    .sign(Algorithm.HMAC256(password));
        } catch (JWTCreationException exception) {
            return null; // 以 password 作为 token 的密钥
            //Invalid Signing configuration / Couldn't convert Claims.
        }
    }

    /**
     * 对密码进行转换
     *
     * @param password 客户端传入登录信息中的密码
     * @return 加密后的密码
     */
    public static String codeFromPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(password.getBytes());
            byte[] src = digest.digest();
            StringBuilder stringBuilder = new StringBuilder();
            // 字节数组转16进制字符串
            // https://my.oschina.net/u/347386/blog/182717
            for (byte aSrc : src) {
                String s = Integer.toHexString(aSrc & 0xFF);
                if (s.length() < 2) {
                    stringBuilder.append('0');
                }
                stringBuilder.append(s);
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException ignore) {
        }
        return null;
    }


    /**
     * 比较密码是否相同
     *
     * @param loginPassword 客户端传入登录信息
     * @param sqlPassword   从数据库中查询出来的用户信息
     * @return 比较结果
     */
    public static boolean isEqualsPassword(String loginPassword, String sqlPassword) {
        return Objects.equals(codeFromPassword(loginPassword), sqlPassword);
    }

    /**
     * 获取token中的userID
     *
     * @param token 客户端传入的token
     * @return token中的用户id
     */
    private static Integer getUserIdFormToken(String token) {
        return Integer.parseInt(JWT.decode(token).getAudience().get(0));
    }

    /**
     * 判断token是否已过期
     *
     * @param token 客户端传入的token
     * @return token是否过期
     */
    private static Boolean isTokenExpired(String token) {
        Date date = JWT.decode(token).getExpiresAt();
        return date.before(new Date());
    }

    /**
     * 验证token是否还有效
     *
     * @param token 客户端传入的token
     * @param user  从数据库中查询出来的用户信息
     * @return token是否还有效
     */
    public boolean validateToken(String token, User user) {
        Integer userId = getUserIdFormToken(token);
        return userId.equals(user.getId()) && !isTokenExpired(token);
    }
}
