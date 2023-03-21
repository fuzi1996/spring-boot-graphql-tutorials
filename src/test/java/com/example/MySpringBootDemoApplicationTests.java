package com.example;

import com.example.user.entity.User;
import com.example.user.mapper.UserMapper;
import org.apache.ibatis.parsing.XNode;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.w3c.dom.Node;

import java.util.List;
import java.util.Map;

@SpringBootTest(classes = MySpringBootDemoApplication.class)
class MySpringBootDemoApplicationTests {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private UserMapper userMapper;

    @Test
    void find() {
        List<User> user = this.userMapper.findUser();
        System.out.println(user.size());
    }

    @Test
    void contextLoads() {
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        Configuration configuration = sqlSession.getConfiguration();
        Map<String, XNode> sqlFragments = configuration.getSqlFragments();

        XNode xNode = sqlFragments.get("test");
        Node node = xNode.getNode();

        System.out.println(1);
    }

}
