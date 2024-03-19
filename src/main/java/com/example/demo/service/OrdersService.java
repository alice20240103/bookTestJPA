package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OrdersDAO;
import com.example.demo.vo.OrdersVO;

import lombok.Setter;

@Service
@Setter
public class OrdersService {
	@Autowired
	private OrdersDAO dao;
	
	public List<OrdersVO> findAll(String keyword){
		if(keyword == null) {
			return dao.findAll();
		}
		else {
			return dao.findByCustomer_Name(keyword);
		}
	}
	
	public int getNextNo() {
		return dao.getNextNo();
	}
	
	public void insert(OrdersVO o) {
		dao.insert(o);
	}
}








