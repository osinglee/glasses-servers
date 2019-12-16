package come.glasses.dao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Description : null.java
 * @auther : modan
 * @create : 2019-12-16 15:18
 */
@Configuration
@PropertySource("classpath:come/glasses/dao/application.properties")
@MapperScan("come.glasses.dao.mapper")
@ComponentScan
public class DaoConfiguration {
}
