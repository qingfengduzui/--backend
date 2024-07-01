//package org.example.test_second.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//    @Bean
//    public Docket createRestApi() {
//        return new Docket (DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .build();
//    }
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("FRMV")//标题
//                .description("新生报到数据监控可视化系统")//具体描述
//                .version("1.0")
//                .build();
//    }
//}
package org.example.test_second.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                // 指定构建api⽂档的详细信息的⽅法：apiInfo()
                .apiInfo(apiInfo())
                .select()
        // 指定要⽣成api接⼝的包路径，这⾥把controller作为包路径，⽣成controller中的所接⼝
 .apis(RequestHandlerSelectors.basePackage("org.example.test_second.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    /**
     * 构建api⽂档的详细信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 设置⻚⾯标题
                .title("学生管理系统api接口文档")
                // 设置接⼝描述
                .description("接⼝描述")
                // 设置版本
                .version("1")
                // 构建
                .build();
    }
}