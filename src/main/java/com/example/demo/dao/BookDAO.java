package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.BookVO;

@Repository
public interface BookDAO extends JpaRepository<BookVO, Integer> {
	
	//도서명 순으로 정렬하는 쿼리 메소드를 추가 해 봅니다.
	public List<BookVO> findAllByOrderByBookname();
	public List<BookVO> findAllByOrderByBookid();
	public List<BookVO> findAllByOrderByPrice();
	public List<BookVO> findAllByOrderByPublisher();
	
	//도서명을 매개변수로 전달받아 검색하는 메소드
	//우리가 생각하는 like가 아니고 equal로 동작함.
	public List<BookVO> findByBooknameLike(String bookname);
	
	//이것이 우리가 생각하는 like를 수행함.
	public List<BookVO> findByBooknameContaining(String bookname);
	public List<BookVO> findByBookid(Integer bookid);
	public List<BookVO> findByPublisherContaining(String keyword);
	public List<BookVO> findByPrice(Integer price);
	
	public List<BookVO> findByBooknameContainingOrderByBookname(String bookname);
	public List<BookVO> findByBookidOrderByBookname(Integer bookid);
	public List<BookVO> findByPublisherContainingOrderByBookname(String keyword);
	public List<BookVO> findByPriceOrderByBookname(Integer price);

	public List<BookVO> findByBooknameContainingOrderByBookid(String bookname);
	public List<BookVO> findByBookidOrderByBookid(Integer bookid);
	public List<BookVO> findByPublisherContainingOrderByBookid(String keyword);
	public List<BookVO> findByPriceOrderByBookid(Integer price);
	
	public List<BookVO> findByBooknameContainingOrderByPrice(String bookname);
	public List<BookVO> findByBookidOrderByPrice(Integer bookid);
	public List<BookVO> findByPublisherContainingOrderByPrice(String keyword);
	public List<BookVO> findByPriceOrderByPrice(Integer price);
	
	public List<BookVO> findByBooknameContainingOrderByPublisher(String bookname);
	public List<BookVO> findByBookidOrderByPublisher(Integer bookid);
	public List<BookVO> findByPublisherContainingOrderByPublisher(String keyword);
	public List<BookVO> findByPriceOrderByPublisher(Integer price);
	
}










