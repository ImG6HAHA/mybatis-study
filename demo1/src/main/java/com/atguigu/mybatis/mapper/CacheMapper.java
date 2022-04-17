package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * AUTHOR: Z
 * CREATE TIME:2022-04-17-0:44
 */
public interface CacheMapper {

    Emp getEmpByEid(@Param("eid") Integer eid);
    //一级缓存范围 sqlsession

}
