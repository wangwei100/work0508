package com.demohot.homework.work0508;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.demohot.homework.work0508.dao.UserMapper;
import com.demohot.homework.work0508.dao.po.User;

import junit.framework.TestCase;

public class AppTest extends TestCase {

	// public AppTest(String testName) {
	// //super(testName);
	// System.out.println("123");
	// }

	public void test() {
		System.out.println("123");
	}

	public void test2() {
		try {
			String resource = "mybatis.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

			SqlSession session = sqlSessionFactory.openSession();
			UserMapper mapper = session.getMapper(UserMapper.class);
			List<User> users = mapper.selectUser();
			for (User user : users) {
				System.out.println(user.getUsername() + user.getPassword());
			}
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
