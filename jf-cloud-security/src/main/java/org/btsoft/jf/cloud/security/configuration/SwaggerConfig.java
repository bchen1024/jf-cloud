package org.btsoft.jf.cloud.security.configuration;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket apiDocket(){
        ApiInfo apiInfo=new ApiInfoBuilder().title("JF Cloud 权限管理")
                .description("JF CLoud 权限管理微服务API中心")
                .termsOfServiceUrl("").version("1.0")
                .contact(new Contact("bchen","","")).build();
        Predicate<RequestHandler> apiSelector= RequestHandlerSelectors
                .basePackage("org.btsoft.jf.cloud.security");
        Predicate<String> pathSelecter= PathSelectors.any();
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo).select()
                .apis(apiSelector).paths(pathSelecter).build();
    }
}
