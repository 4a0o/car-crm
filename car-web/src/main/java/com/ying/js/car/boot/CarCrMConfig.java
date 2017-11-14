package com.ying.js.car.boot;

import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.view.velocity.VelocityLayoutViewResolver;

/**
 * 村淘模块配置
 *
 * @author risheng
 */
@Configuration
//@MapperScan("com.ying")
public class CarCrMConfig {

    @Bean(name = "velocityViewResolver")
    public VelocityLayoutViewResolver getVelocityLayoutViewResolver() {
        VelocityLayoutViewResolver vr = new VelocityLayoutViewResolver();
        vr.setCache(true);
        vr.setPrefix("/templates/");
        vr.setSuffix(".vm");
        vr.setLayoutUrl("layout.vm");
        vr.setContentType("text/html;charset=UTF-8");
        vr.setExposeSpringMacroHelpers(true);
        vr.setLayoutKey("layout");
        vr.setScreenContentKey("screen_content");
        vr.setDateToolAttribute("dateTool");
        vr.setNumberToolAttribute("numberTool");
        vr.setAllowRequestOverride(true);
        vr.setAllowSessionOverride(true);
        vr.setExposeRequestAttributes(true);
        vr.setExposeSessionAttributes(true);
        vr.setRequestContextAttribute("rc");
        return vr;
    }


    @Bean(name = "cuntaoThreadPool")
    public ThreadPoolTaskExecutor cuntaoThreadPool() {
        ThreadPoolTaskExecutor poolTaskExecutor = new ThreadPoolTaskExecutor();
        poolTaskExecutor.setQueueCapacity(200);
        poolTaskExecutor.setCorePoolSize(5);
        poolTaskExecutor.setMaxPoolSize(20);
        poolTaskExecutor.setKeepAliveSeconds(300);
        poolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return poolTaskExecutor;
    }

 /*   @Bean
    MultipartConfigElement multipartConfigElement() {
       MultipartConfigFactory factory = new MultipartConfigFactory();
       factory.setLocation("/home/admin/alicpaccount/logs");
       return factory.createMultipartConfig();
   }*/

}
