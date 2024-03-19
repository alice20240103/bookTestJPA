package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookDAO;
import com.example.demo.vo.BookVO;

import lombok.Setter;

//@Service
//@Setter
public class BookService2 {
	@Autowired
	private BookDAO dao;
	
	public BookVO findById(int bookid) {
		BookVO b = null;
		//jpa의 findById는 VO를 반환하지 않고 
		//VO을 Optional로 포장해서 반환합니다.
		Optional<BookVO> o = dao.findById(bookid);
		if(o.isPresent()) {
			b = o.get();
		}
		return b;
	}
	
	
	public List<BookVO> findAll(HashMap<String, String> map){		
		//return dao.findAll();
		String cname = map.get("cname");
		String keyword = map.get("keyword");
		List<BookVO> list = null;
				
		if(keyword != null && !keyword.equals("")) {
			switch(cname) {
				case "bookid":list = dao.findByBookid( Integer.parseInt( keyword) );break;
				case "bookname":list = dao.findByBooknameContaining(keyword);break;
				case "publisher":list = dao.findByPublisherContaining(keyword);break;
				case "price":list=dao.findByPrice(Integer.parseInt( keyword));break;
			}
		}
		else {
			return dao.findAllByOrderByBookname();
		}
		return list;
	}
	
	//pk에 해당하는 레코드가 이미있으면 update를 수행하고 
	//그렇지 않으면 insert를 수행합니다.
	public void save(BookVO b) {
		dao.save(b);
	}
	
	public void delete(int bookid) {
		dao.deleteById(bookid);
	}
}








