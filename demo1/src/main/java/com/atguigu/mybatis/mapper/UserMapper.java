package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * AUTHOR: Z
 * CREATE TIME:2022-04-13-19:57
 */
public interface UserMapper {

    //添加
    int insertUser();

    void updateUser();

    void deleteUser();

    User findById(Integer id);

    List<User> findAll();

    User findByName(String name);

    User checkLogin(@Param("username") String name, @Param("password") String password);

    int insertUserByUser(User user);

    int findCount();

    Map<String,Object> findByIdToMap(Integer id);//查询出的一条数据--组成一个Map集合

//    List<Map<String,Object>> findAllToMap();

    @MapKey("id")//将数据id设置为Map的键
    Map<String,Object> findAllToMap();

    //模糊检索
    List<User> findByBlurry(String name);
//1    select* from t_user where username like '%${name}%'
//2    select* from t_user where username like concat ('%',#{name},'%')
//3    select* from t_user where username like "%"#{name}"%"   常用

    //批量删除
    int batchDeletion(String ids);
    // in (${ids})

    //从指定表中查询
    List<User> findByTable(String tableName);
}
