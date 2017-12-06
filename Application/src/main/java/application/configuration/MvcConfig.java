package application.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
        configurer.enable();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/login");
        registry.addViewController("/login").setViewName("/login");
        registry.addViewController("/home").setViewName("/home");
        registry.addViewController("/register").setViewName("/register");

        //Admin pages
        registry.addViewController("/admin/add").setViewName("admin/add");
        registry.addViewController("/admin/status").setViewName("admin/status");
        registry.addViewController("/admin/tracking").setViewName("admin/tracking");

        //User pages
        registry.addViewController("/user/search").setViewName("user/search");
        registry.addViewController("/user/status").setViewName("user/status");
        registry.addViewController("/user/view").setViewName("user/view");
    }
}
