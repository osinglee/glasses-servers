package come.glasses.serviceImpl.user;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import come.glasses.entity.UserEntity;
import come.glasses.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @Description : null.java
 * @auther : modan
 * @create : 2019-08-21 11:46
 */
public class HeaderTokenWebFilter extends OncePerRequestFilter {

    private UserService userService;

    HeaderTokenWebFilter(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, javax.servlet.FilterChain filterChain) throws ServletException, IOException {
// 获取header中的令牌或参数中的令牌
        String token = request.getHeader("token");

        // 空token或没有直接返回
        if (token == null || token.isEmpty()) {
            filterChain.doFilter(request, response);
            return;
        }
        int userId;
        try {
            userId = Integer.parseInt(JWT.decode(token).getAudience().get(0));  // 获取 token 中的 user id
        } catch (JWTDecodeException e) {
            filterChain.doFilter(request, response);
            return;
        }
        Date date = JWT.decode(token).getExpiresAt();  // 获取 token 中的 user id
        if (date.before(new Date())) {
            filterChain.doFilter(request, response);
            return;
        }
        // 通过数据库验证
        UserEntity user = userService.findById(userId);
        if (user == null) {
            filterChain.doFilter(request, response);
            return;
        }
        request.setAttribute("currentUser", user);
        AuthenticateServiceImpl authentication = new AuthenticateServiceImpl(user);
        authentication.setAuthenticated(true);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request, response);
    }
}
