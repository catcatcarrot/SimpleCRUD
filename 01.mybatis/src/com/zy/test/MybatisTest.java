package com.zy.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.zy.bean.Customer;
import com.zy.dao.CustomerMapper;

public class MybatisTest {

	@Test
	public void test() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
			
			Customer customer = new Customer();
			customer.setAddress("西安");
			customer.setGender("女");
			customer.setName("斯特沃克");
			customer.setTelephone("170000");
			
			mapper.addCustomer(customer);
			
			sqlSession.commit();
		}finally {
			sqlSession.close();
		}
	}
	
	private SqlSessionFactory getSqlSessionFactory() throws IOException {
		// TODO Auto-generated method stub
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
}
