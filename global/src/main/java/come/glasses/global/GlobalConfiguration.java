package come.glasses.global;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Description : null.java
 * @auther : modan
 * @create : 2019-08-16 16:00
 */
@Configuration // 配置注解
@PropertySource("classpath:come/glasses/global/application.properties")
@ComponentScan
@AutoConfigureBefore({FlywayAutoConfiguration.class})
@ImportAutoConfiguration({FlywayAutoConfiguration.class, DataSourceAutoConfiguration.class})
public class GlobalConfiguration {

}