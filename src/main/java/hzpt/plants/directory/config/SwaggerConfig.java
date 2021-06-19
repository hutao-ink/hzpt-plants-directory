package hzpt.plants.directory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;


/**
 * @Author: tfj
 * @Date: 2021/6/6 13
 * @Description:
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.OAS_30).pathMapping("/")
                // 开启个人信息
                .apiInfo(apiInfo())
                // 选择哪些接口作为swagger的doc发布
                .select()
                .build();
    }

    /**
     * 个人信息
     */
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //api文本
                .title("HuTao api")
                //说明
                .description("")
                //用户名 + 网址 + 邮箱
                .contact(new Contact("directory" ,
                        "" ,
                        ""))
                //版本
                .version("3.0")
                //运行
                .build();
    }
}
