package com.ying.js.car.dao.mapper;

import com.ying.js.car.dao.model.ConsumerDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by IntelliJ IDEA.
 * User: chengjing
 * Date: 17/11/13
 * Time: 下午5:34
 * CopyRight: taobao
 * Descrption:
 */

//@Mapper
public interface ConsumerDAO {


    int deleteByPrimaryKey(Long id);

    int insert(ConsumerDO record);

    int insertSelective(ConsumerDO record);

    @Select("select * from consumer where id=#{id}")
    ConsumerDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ConsumerDO record);

    int updateByPrimaryKey(ConsumerDO record);
}
