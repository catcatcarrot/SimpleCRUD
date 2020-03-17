package com.zy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zy.bean.Customer;

public interface CustomerMapper {
	
	public List<Customer> selectAll();

	public void save(Customer customer);

	public Customer findById(Integer id);

	public void update(Customer customer);

	public void delete(Integer[] id);
	
	

}
