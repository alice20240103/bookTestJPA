package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.service.BookService;
import com.example.demo.vo.BookVO;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpSession;
import lombok.Setter;

@Controller
@Setter
public class BookController {
	@Autowired
	private BookService bs;
	
	@GetMapping("/book/delete")
	public String delete(int bookid) {
		String view = "redirect:/book/list";
		bs.delete(bookid);
		return view;
	}
	
	
	@GetMapping("/book/update")
	public void update(int bookid, Model model) {
		model.addAttribute("b", bs.findById(bookid));
	}
	
	@GetMapping("/book/detail")
	public void detail(int bookid, Model model) {
		model.addAttribute("b", bs.findById(bookid));
	}
	
	
	@GetMapping("/book/list")
	public void list(Model model,String cname, String keyword, String sname, HttpSession session) {
		System.out.println("컨틀로러에서 sname:"+sname);
		HashMap<String, String> map = new HashMap<String,String>();		
		String cname2 = null;
		String keyword2 = null;		
		if( session.getAttribute("keyword") != null  ) {
			cname2 = (String)session.getAttribute("cname");
			keyword2 = (String)session.getAttribute("keyword");
		}		
		if(keyword != null) {
			cname2 = cname;
			keyword2 = keyword;
			session.setAttribute("cname", cname);
			session.setAttribute("keyword", keyword);
		}		
		map.put("cname", cname2);
		map.put("keyword", keyword2);
		map.put("sname", sname);
		model.addAttribute("list", bs.findAll(map));
	}
	
	@PostMapping("/book/save")
	public String save(BookVO b) {
		String view = "redirect:/book/list";
		bs.save(b);
		return view;
	}
}









