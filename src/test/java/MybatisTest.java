import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author:wenwei
 * @date:2020/02/24
 * @description:
 */
public class MybatisTest {



  public void test() throws IOException {

    //读取配置文件，读成字节输入流，
    InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

    //解析配置文件，封装configuration对象，创建DefaultSqlsessionFacoty
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);


    SqlSession sqlSession = sqlSessionFactory.openSession();

    List<Object> objects = sqlSession.selectList("namespace.id");


  }

  @Test
  public void test2() throws IOException {
    //读取配置文件，读成字节输入流，
    InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

    //解析配置文件，封装configuration对象，创建DefaultSqlsessionFacoty
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);


    SqlSession sqlSession = sqlSessionFactory.openSession();
    //使用JDK动态代理对mapper接口产生代理对象
    IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
    //代理对象调用接口的任意方法，执行都是代理的invoke方法
    List<Object> all = mapper.findAll();

  }
}
