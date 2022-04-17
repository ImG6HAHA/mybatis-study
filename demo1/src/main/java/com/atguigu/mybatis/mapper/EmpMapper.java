package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;

import java.util.List;

/**
 * AUTHOR: Z
 * CREATE TIME:2022-04-14-22:37
 */
public interface EmpMapper {

    List<Emp> findAll();
    //字段名和数据库不一致 解决方法

    //1 select eid,emp_name empName,age,sex,email from t_emp   字段取别名

    //2 mybatis-config配置文件配置 会将数据库里面下划线转为驼峰
//    <settings>
//        <setting name="mapUnderscoreToCamelCase" value="true"/>
//    </settings>

    //3 配置 resultMap
//    <mapper namespace="com.atguigu.mybatis.mapper.EmpMapper">
//    <resultMap id="empResultMap" type="Emp">
//        <id property="eid" column="eid"/>    id设置主键字段
//        <result property="empName" column="emp_name"/>
//        <result property="age" column="age"/>
//        <result property="sex" column="sex"/>
//        <result property="email" column="email"/>
//    </resultMap>

    Emp getEmpAndDept(Integer eid);
    //处理多对一的映射关系
//    1 级联属性赋值
//    2 association标签







}
