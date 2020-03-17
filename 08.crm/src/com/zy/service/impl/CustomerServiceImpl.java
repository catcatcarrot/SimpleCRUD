package com.zy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zy.bean.Customer;
import com.zy.dao.CustomerMapper;
import com.zy.service.CustomerService;

@Service//("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
	//注入Mapper对象
	@Resource
	private CustomerMapper customerMapper;

	@Override
	public List<Customer> selectAll() {
		return customerMapper.selectAll();
	}

	@Override
	public void save(Customer customer) {
		//判断是添加还是修改
		if(customer.getId()!=null) {
			//修改
			customerMapper.update(customer);
		}else {
			//增加
			customerMapper.save(customer);
		}
	}

	@Override
	public Customer findById(Integer id) {
		return customerMapper.findById(id);
	}

	@Override
	public void delete(Integer[] id) {
		customerMapper.delete(id);
	}
	
}
