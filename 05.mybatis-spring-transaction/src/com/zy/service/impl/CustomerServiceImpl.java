package com.zy.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zy.bean.Customer;
import com.zy.dao.CustomerMapper;
import com.zy.service.CustomerService;

@Service//("customerService")
//@Transactional
public class CustomerServiceImpl implements CustomerService {
	//注入Mapper对象
	@Resource
	private CustomerMapper customerMapper;

	@Transactional
	@Override
	public void addCustomer(Customer customer) {
		customerMapper.addCustomer(customer);
		
		//模拟异常
//		int i = 100/0;
		
		customerMapper.addCustomer(customer);
	}

	@Transactional
	@Override
	public void test1() {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public void test2() {
		// TODO Auto-generated method stub
		
	}

}
