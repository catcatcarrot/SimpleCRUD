package com.zy.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zy.bean.Customer;
import com.zy.dao.CustomerMapper;

public class MybatisSpringTest {

	@Test
	public void test() {
		//1.����spring����
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//2.��ȡ����
		CustomerMapper customerMapper = (CustomerMapper) ac.getBean("customerMapper");
		
		//3.���÷���
		Customer customer = new Customer();
		customer.setAddress("����");
		customer.setGender("Ů");
		customer.setName("˹���ֿ�");
		customer.setTelephone("170000");
		
		customerMapper.addCustomer(customer);
		
	}
	
}
