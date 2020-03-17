package com.zy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zy.bean.Customer;
import com.zy.service.CustomerService;

@Controller
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	/**
	 * ��ѯ�������ݣ���ҳ�淵��json��ʽ����
	 * easyui��datagrid�������Ҫչʾ���ṩjson���ݣ�[{id:1,name:xxx}{id:1,name:xxx}]
	 * */
	@RequestMapping("list")
	@ResponseBody  //����ת������Ϊjson
	public List<Customer> list(){
		List<Customer> list =  customerService.selectAll();
		return list;
	}
	
	//���Map�ۺϴ洢��Ҫ��ҳ��Ķ�������
	private Map<String,Object> result = new HashMap<>();
	
	/**
	 * ��ҳ��ѯ
	 * */
	@RequestMapping("listByPage")
	@ResponseBody  //����ת������Ϊjson
	public Map<String,Object> listByPage(Integer page,Integer rows){
		//���÷�ҳ����
		PageHelper.startPage(page, rows);
		//��ѯ��������
		List<Customer> list =  customerService.selectAll();
		
		//ʹ��PageInfo��װ���в�ѯ���
		PageInfo<Customer> pageInfo = new PageInfo<Customer>(list);
		
		//��PageInfo����ȡ����ѯ���
		//�ܼ�¼��
		long total = pageInfo.getTotal();
		//��ǰҳ�����б�
		List<Customer> custList = pageInfo.getList();
		
		result.put("total", total);
		result.put("rows", custList);
		
		return result;
	}
	
	/**
	 * ��������
	 * */
	@RequestMapping("save")
	@ResponseBody
	public Map<String,Object> save(Customer customer){
		try {
			customerService.save(customer);
			result.put("success", true);
		}catch(Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", e.getMessage());
		}
		return result;
	}
	
	/**
	 * ����id��ѯ����
	 * */
	@RequestMapping("findById")
	@ResponseBody
	public Customer findById(Integer id1) {
		Customer customer =  customerService.findById(id1);
		return customer;
	}
	
	/**
	 * ɾ������
	 * */
	@RequestMapping("delete")
	@ResponseBody
	public Map<String,Object> delete(Integer[] id){
		try {
			customerService.delete(id);
			result.put("success", "true");
		}catch(Exception e) {
			e.printStackTrace();
			result.put("success", "false");
			result.put("msg", e.getMessage());
		}
		return result;
	}
	
	@RequestMapping("test")
	public String test(@RequestParam("i") Integer[] ids) {
		for(int i:ids) {
			System.out.println(i);
		}
		return "success";
	}
	
	@RequestMapping("/getJson")
	@ResponseBody
	public Map<String,String[]> getJson(){
		Map<String,String[]> map = new HashMap<String, String[]>();
		String[] str1 = new String[] {"����","��ѧ","Ӣ��",null,"��ʷ"};
		map.put("����һ", str1);
		String[] str2 = new String[] {"����","��ѧ","Ӣ��",null,"��ʷ"};
		map.put("���ڶ�", str2);
		return map;
	}
	
}
