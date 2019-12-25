package come.glasses.api;

import cn.hutool.json.JSONUtil;
import come.glasses.utils.JSONResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description : null.java
 * @auther : modan
 * @create : 2019-12-24 16:32
 */
@Component
public class ResAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JSONUtil.parse(JSONResult.error("暂未登录或token已经过期" + authException.getMessage())));
        response.getWriter().flush();
    }
}
