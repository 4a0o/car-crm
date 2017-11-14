package com.ying.js.car.boot;

import org.slf4j.LoggerFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Created by IntelliJ IDEA.
 * User: chengjing
 * Date: 16/12/9
 * Time: 下午2:12
 * CopyRight: taobao
 * Descrption:
 */
@Configuration
public class MyWebAppConfigurer implements EnvironmentAware {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(MyWebAppConfigurer.class);

    private RelaxedPropertyResolver propertyResolver;

    @Override
    public void setEnvironment(Environment env) {
        String javaHome = env.getProperty("JAVA_HOME");
        String profile = env.getProperty("spring.profiles.active");
        String serverPort = env.getProperty("server.port");
        propertyResolver = new RelaxedPropertyResolver(env, "spring.datasource.");
        String dbUrl = propertyResolver.getProperty("url");
        logger.info("####当前环境信息####");
        logger.info("--profile={}, JAVA_HOME={}, port={} --", profile, javaHome, serverPort);
    }
}
