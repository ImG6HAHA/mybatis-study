package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * AUTHOR: Z
 * CREATE TIME:2022-04-16-20:44
 */
public interface DynamicSQLMapper {

    //多条件查询
    List<Emp> getEmpByCondition(Emp emp);

    /*
    * 动态sql
    * 1 if标签:可通过test属性（即传递过来的数据）的表达式进行判断，若表达式的结果为true，则标签中的内容会执行；反之标签中的内容不会执行
    *
    * 2 where标签
    *   若where标签中的if条件都不满足，则where标签没有任何功能，即不会添加where关键字
        若where标签中的if条件满足，则where标签会自动添加where关键字，并将条件最前方多余的and/or去掉 不能将后面多余的and/or去掉

      * 3 trim标签
      * trim用于去掉或添加标签中的内容
        常用属性
        prefix：在trim标签中的内容的前面添加某些内容
        suffix：在trim标签中的内容的后面添加某些内容
        prefixOverrides：在trim标签中的内容的前面去掉某些内容
        suffixOverrides：在trim标签中的内容的后面去掉某些内容
        若trim中的标签都不满足条件，则trim标签没有任何效果，也就是只剩下select * from t_emp

        4 choose when otherwise 相当于 if else
        *

        5 foreach标签
        * collection 设置需要循环的数组或集合
        * item 数组或元素里面的每一个元素
        *

*       6 sql标签
*           定义 <sql id="empColumns">eid,emp_name,age,sex,email</sql>
*           引用 select <include refid="empColumns"></include> from t_emp
    * */


    //测试choose when otherwise
    List<Emp> getEmpByChoose(Emp emp);
    /*
    * when至少有一个 otherwise最多只能有一个
    *
    *
    * */

    //批量删除
    int deleteMoreByArray(@Param("eids") Integer[] eids);

    //批量添加
    int insertMoreByMore(@Param("emps") List<Emp> emps);
}
