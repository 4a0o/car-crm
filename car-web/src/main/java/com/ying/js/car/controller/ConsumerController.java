package com.ying.js.car.controller;

import com.ying.js.car.dao.mapper.ConsumerDAO;
import com.ying.js.car.dao.model.ConsumerDO;
import com.ying.js.car.service.ConsumerService;
import com.ying.js.car.service.ConsumerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * User: chengjing
 * Date: 17/11/14
 * Time: 上午9:17
 * CopyRight: taobao
 * Descrption:
 */
@RestController
@RequestMapping({"/consumer"})
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;

    @RequestMapping(value = "/user")
    @ResponseBody
    public String user() {

        ConsumerVO consumerVO = consumerService.getConsumerById(1L);
        System.out.println("consumerDO=" + consumerVO);
        return "ok";
    }
}
