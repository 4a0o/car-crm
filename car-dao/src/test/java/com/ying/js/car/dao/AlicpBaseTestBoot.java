package com.ying.js.car.dao;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan({"com.ying"})
@SpringApplicationConfiguration(AlicpBaseTestBoot.class)
@SpringBootApplication
@EnableTransactionManagement

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = AlicpBaseTestBoot.class)
@WebIntegrationTest("server.port:7002")
//@ImportResource({"classpath*:config/prize-mybatis.xml","classpath*:config/common-aop.xml"})
public class AlicpBaseTestBoot {
	
	protected static final Logger logger = LoggerFactory.getLogger(AlicpBaseTestBoot.class);
	
}
