package come.glasses.api;

import come.glasses.serviceImpl.user.EcSecurityConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
    private EcSecurityConfigurer ecSecurityConfigurer;

    @Autowired
    public SecurityConfigurer(EcSecurityConfigurer ecSecurityConfigurer) {
        this.ecSecurityConfigurer = ecSecurityConfigurer;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ecSecurityConfigurer.httpSecurityConfigure(http)
                .authorizeRequests()
//                .antMatchers("/MH0202/**").hasAnyAuthority("mh:0202:manage")
//                .antMatchers("/MH*/**", "/swagger*/**", "/v2/api-docs").permitAll()
                .antMatchers("**").permitAll()
                .anyRequest().fullyAuthenticated()
                .and().csrf().disable();
    }
}
