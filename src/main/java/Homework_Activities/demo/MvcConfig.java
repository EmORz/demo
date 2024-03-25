package Homework_Activities.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/registration").setViewName("registration");
        registry.addViewController("/user-details").setViewName("user-details");
        registry.addViewController("/activities/create").setViewName("create-activity");

        registry.addViewController("/login").setViewName("login");
    }
}
