import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.pojo.EmpExample;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * AUTHOR: Z
 * CREATE TIME:2022-04-17-16:59
 */
public class MBGTest {

    @Test
    public void test1() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
//        List<Emp> list = empMapper.selectByExample(null); //查询所有

        //根据条件查询
        /*EmpExample empExample = new EmpExample();
        empExample.createCriteria().andEmpNameEqualTo("a1").andAgeGreaterThanOrEqualTo(10);//构造条件
        empExample.or().andDidEqualTo(1);
        List<Emp> list = empMapper.selectByExample(empExample);
        list.forEach(x-> System.out.println(x));*/
        empMapper.updateByPrimaryKey(new Emp(11,"admin",22,null,"123.com",1));

    }

    @Test
    public void pageHelperTest() throws IOException{
        SqlSession sqlSession = SqlSessionUtils.getSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        PageHelper.startPage(1,4);//第几页 每页多少条数据
        List<Emp> list = empMapper.selectByExample(null);
        PageInfo<Emp> info=new PageInfo<>(list,3);//信息
        System.out.println(info);
        list.forEach(x-> System.out.println(x));
    }


}
