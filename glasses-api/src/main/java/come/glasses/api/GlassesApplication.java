package come.glasses.api;
import come.glasses.dao.DaoConfiguration;
import come.glasses.global.GlobalConfiguration;
import come.glasses.utils.UtilsConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.function.Predicate;

/**
 * @Description : null.java
 * @auther : modan
 * @create : 2019-11-07 11:57
 */
@SpringBootApplication(scanBasePackages = {"come.glasses"})
@Import({UtilsConfiguration.class, GlobalConfiguration.class, DaoConfiguration.class})
@EnableSwagger2
public class GlassesApplication {
    public static void main(String[] args) {
        SpringApplication.run(GlassesApplication.class, args);
    }

    @Bean
    public Docket createRestApi() {
        // swagger 扫描MH的api
        Predicate<RequestHandler> mhSelector = RequestHandlerSelectors.basePackage("come.glasses.api")::apply;
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(mhSelector::test)
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("api")
                .description("API工具")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
}
