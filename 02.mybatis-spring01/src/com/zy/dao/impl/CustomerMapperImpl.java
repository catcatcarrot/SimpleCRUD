package com.zy.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.zy.bean.Customer;
import com.zy.dao.CustomerMapper;

public class CustomerMapperImpl extends SqlSessionDaoSupport implements CustomerMapper {

	@Override
	public void addCustomer(Customer customer) {
		SqlSession sqlSession =  this.getSqlSession();
		sqlSession.insert("addCustomer", customer);
		
		//这里不需要事物提交
	}

}
