package com.zy.service;

import java.util.List;

import com.zy.bean.Customer;

public interface CustomerService {

	public List<Customer> selectAll();

	public void save(Customer customer);

	public Customer findById(Integer id);

	public void delete(Integer[] id);
}
