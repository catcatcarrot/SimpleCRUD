package com.zy.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zy.bean.Customer;
import com.zy.dao.CustomerMapper;
import com.zy.service.CustomerService;

public class MybatisSpringTest {

	@Test
	public void test() {
		//1.����spring����
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//2.��ȡ����
		CustomerService customerService = (CustomerService) ac.getBean("customerServiceImpl");
		
		//3.���÷���
		Customer customer = new Customer();
		customer.setAddress("����");
		customer.setGender("��");
		customer.setName("TW");
		customer.setTelephone("140000");
		
		customerService.addCustomer(customer);
		
	}
	
}
