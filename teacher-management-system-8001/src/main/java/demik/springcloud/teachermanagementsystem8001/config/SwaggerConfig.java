package demik.springcloud.teachermanagementsystem8001.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

/**
 * Function: swagger配置类
 *
 * @author
 * Date: 2018/10/12 下午2:23
 * @since JDK 1.8
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.enabled}")
    private Boolean enabledSwagger;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //是否开启Swagger
                .enable(enabledSwagger)
                .select()
                //指定扫描添加了@ApiOperation注解的请求/Users/lcxy_demo/IdeaProjects/micor-service-parent/micor-service-provider-dept-8001/src/main/java/lcxy/springcloud/micorserviceproviderdept8001
                .apis(RequestHandlerSelectors.basePackage("demik.springcloud.teachermanagementsystem8001.controller"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(
                        Arrays.asList(new ApiKey("Authorization", "Authorization", "header"))
                );
    }

    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .title("student-management-system")
                .description("学生管理系统服务端接口1")
                .version("1.0-SNAPSHOT")
                .build();
    }

}
