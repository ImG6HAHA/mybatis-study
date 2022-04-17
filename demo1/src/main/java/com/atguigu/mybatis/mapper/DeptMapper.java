package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Dept;

/**
 * AUTHOR: Z
 * CREATE TIME:2022-04-14-22:37
 */
public interface DeptMapper {

        Dept findDeptAndEmp(Integer did);
        //处理一对多 collection标签   ofType：表示对应"多"的集合类型

}
