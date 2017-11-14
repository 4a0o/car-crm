package com.ying.js.car.dao;
import net.minidev.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by IntelliJ IDEA.
 * User: chengjing
 * Date: 17/11/14
 * Time: 下午1:53
 * CopyRight: taobao
 * Descrption:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes =DataSourceTests.class )
public class DataSourceTests {

    @Autowired
      ApplicationContext applicationContext;

      @Autowired
      DataSouceConfig dataSourceProperties;

      @Test
      public void testDataSource() throws Exception {
          // 获取配置的数据源
          DataSource dataSource = applicationContext.getBean(DataSource.class);
          // 查看配置数据源信息
          System.out.println(dataSource);
          System.out.println(dataSource.getClass().getName());
          System.out.println(dataSourceProperties);
      }
}
