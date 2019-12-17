package come.glasses.serviceImpl.user;

import come.glasses.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component
public class EcSecurityConfigurer {

    private final UserService userService;

    @Autowired
    public EcSecurityConfigurer(UserService userService) {
        this.userService = userService;
    }

    public HttpSecurity httpSecurityConfigure(HttpSecurity http) throws Exception {
        return http.addFilterBefore(new HeaderTokenWebFilter(userService), BasicAuthenticationFilter.class)
//                .authenticationProvider(jwtAuthenticationProvider)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/auth/login").permitAll()
                .and();
    }
}