package com.zy.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zy.bean.Customer;
import com.zy.dao.CustomerMapper;

public class MybatisSpringTest {

	@Test
	public void test() {
		//1.加载spring配置
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//2.获取对象
		CustomerMapper customerMapper = (CustomerMapper) ac.getBean("customerMapper");
		
		//3.调用方法
		Customer customer = new Customer();
		customer.setAddress("西安");
		customer.setGender("女");
		customer.setName("斯特沃克");
		customer.setTelephone("170000");
		
		customerMapper.addCustomer(customer);
		
	}
	
}
