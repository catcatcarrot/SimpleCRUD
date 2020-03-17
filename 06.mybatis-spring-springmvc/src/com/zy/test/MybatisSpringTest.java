package com.zy.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zy.bean.Customer;
import com.zy.dao.CustomerMapper;
import com.zy.service.CustomerService;

public class MybatisSpringTest {

	@Test
	public void test() {
		//1.加载spring配置
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//2.获取对象
		CustomerService customerService = (CustomerService) ac.getBean("customerServiceImpl");
		
		//3.调用方法
		Customer customer = new Customer();
		customer.setAddress("西安");
		customer.setGender("男");
		customer.setName("TW");
		customer.setTelephone("140000");
		
		customerService.addCustomer(customer);
		
	}
	
}
