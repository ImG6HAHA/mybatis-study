import com.atguigu.mybatis.mapper.*;
import com.atguigu.mybatis.pojo.Dept;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * AUTHOR: Z
 * CREATE TIME:2022-04-13-20:10
 */
public class MyBatisTest {



    @Test
    public void test1() throws IOException {

        //加载核心配置文件
        InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        //获得SqlSessionFactory
        SqlSessionFactory sessionFactory = factoryBuilder.build(stream);
        //获取SqlSession
        SqlSession sqlSession = sessionFactory.openSession(true);//自动提交
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //执行方法
        int i = userMapper.insertUser();
        //提交事务
//        sqlSession.commit();
        System.out.println(i);

    }
    @Test
    public void test2() throws IOException{
        //加载核心配置文件
        InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        //获得SqlSessionFactory
        SqlSessionFactory sessionFactory = factoryBuilder.build(stream);
        //获取SqlSession
        SqlSession sqlSession = sessionFactory.openSession(true);//自动提交
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.updateUser();
    }
    @Test
    public void test3() throws IOException{
        //加载核心配置文件
        InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        //获得SqlSessionFactory
        SqlSessionFactory sessionFactory = factoryBuilder.build(stream);
        //获取SqlSession
        SqlSession sqlSession = sessionFactory.openSession(true);//自动提交
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUser();
    }

    @Test
    public void test4() throws IOException{
        //加载核心配置文件
        InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        //获得SqlSessionFactory
        SqlSessionFactory sessionFactory = factoryBuilder.build(stream);
        //获取SqlSession
        SqlSession sqlSession = sessionFactory.openSession(true);//自动提交
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User byId = userMapper.findById(3);
        System.out.println(byId);
    }

    @Test
    public void test5() throws IOException{
//        //加载核心配置文件
//        InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
//        //获取SqlSessionFactoryBuilder
//        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
//        //获得SqlSessionFactory
//        SqlSessionFactory sessionFactory = factoryBuilder.build(stream);
//        //获取SqlSession
//        SqlSession sqlSession = sessionFactory.openSession(true);//自动提交

        SqlSession sqlSession = SqlSessionUtils.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.findAll();
        list.forEach(item->{
            System.out.println(item);
        });

    }

    @Test
    public void test6() throws IOException{
        SqlSession sqlSession = SqlSessionUtils.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findByName("admin1");
        System.out.println(user);
    }

    @Test
    public void test7() throws IOException{
        SqlSession sqlSession = SqlSessionUtils.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.checkLogin("admin1","123456");
        System.out.println(user);
    }
    @Test
    public void test8() throws IOException{
        SqlSession sqlSession = SqlSessionUtils.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null,"tom","123456",18,"男","45345@qq.com");
        int i = userMapper.insertUserByUser(user);
        System.out.println(i);
    }
    @Test
    public void test9() throws IOException{
        SqlSession sqlSession = SqlSessionUtils.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.findCount();
        System.out.println(i);
    }

    @Test
    public void test10() throws IOException{
        SqlSession sqlSession = SqlSessionUtils.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = userMapper.findByIdToMap(3);
        System.out.println(map);
    }

    @Test
    public void test11() throws IOException{
        SqlSession sqlSession = SqlSessionUtils.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = userMapper.findAllToMap();
        System.out.println(map);
    }

    @Test
    public void test12() throws IOException{
        SqlSession sqlSession = SqlSessionUtils.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.findByBlurry("dm");
        System.out.println(list);
    }

    @Test
    public void test13() throws IOException{
        SqlSession sqlSession = SqlSessionUtils.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.batchDeletion("3,5");
        System.out.println(i);
    }

    @Test
    public void test14() throws IOException{
        SqlSession sqlSession = SqlSessionUtils.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> t_user = userMapper.findByTable("t_user");
        System.out.println(t_user);
    }


    ///////////////////////////////////////////////////////// Emp
    @Test
    public void test15() throws IOException{
        SqlSession sqlSession = SqlSessionUtils.getSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> list = empMapper.findAll();
        list.forEach(x-> System.out.println(x));
    }

    @Test
    public void test16() throws IOException{
        SqlSession sqlSession = SqlSessionUtils.getSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp empAndDept = empMapper.getEmpAndDept(3);
        System.out.println(empAndDept);
    }

    ///////////////////////////////////////////////////////// Dept
    @Test
    public void test17() throws IOException{
        SqlSession sqlSession = SqlSessionUtils.getSession();
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        Dept deptAndEmp = deptMapper.findDeptAndEmp(1);
        System.out.println(deptAndEmp);
    }

    ///////////////////////////////////////////////////////// DynamicSQLMapper
    @Test
    public void test18() throws IOException{
        SqlSession sqlSession = SqlSessionUtils.getSession();
        DynamicSQLMapper dynamicSQLMapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> empByCondition = dynamicSQLMapper.getEmpByCondition(new Emp(null,"a1",null,"",""));
        empByCondition.forEach(x-> System.out.println(x));
    }

    @Test
    public void test19() throws IOException{
        SqlSession sqlSession = SqlSessionUtils.getSession();
        DynamicSQLMapper dynamicSQLMapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> empByChoose = dynamicSQLMapper.getEmpByChoose(new Emp(null,"",null,"",""));
        empByChoose.forEach(x-> System.out.println(x));
    }

    @Test
    public void test20() throws IOException{
        SqlSession sqlSession = SqlSessionUtils.getSession();
        DynamicSQLMapper dynamicSQLMapper = sqlSession.getMapper(DynamicSQLMapper.class);
        int i = dynamicSQLMapper.deleteMoreByArray(new Integer[]{6,7,8});
        System.out.println(i);

    }

    @Test
    public void test21() throws IOException{
        SqlSession sqlSession = SqlSessionUtils.getSession();
        DynamicSQLMapper dynamicSQLMapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null,"a1",11,"男","123.com");
        Emp emp2 = new Emp(null,"a2",11,"男","123.com");
        Emp emp3 = new Emp(null,"a3",11,"男","123.com");
        List<Emp> list = Arrays.asList(emp1, emp2, emp3);
        int i = dynamicSQLMapper.insertMoreByMore(list);
        System.out.println(i);
    }

    @Test
    public void test22() throws IOException{
        SqlSession sqlSession = SqlSessionUtils.getSession();
        CacheMapper cacheMapper = sqlSession.getMapper(CacheMapper.class);
        Emp empByEid1 = cacheMapper.getEmpByEid(11);
        System.out.println(empByEid1);

        sqlSession.clearCache();//清空缓存

        Emp empByEid2 = cacheMapper.getEmpByEid(11);
        System.out.println(empByEid2);

    }

}
