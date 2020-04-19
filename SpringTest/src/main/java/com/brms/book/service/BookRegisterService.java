package com.brms.book.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.brms.book.Book;
import com.brms.book.dao.BookDao;

public class BookRegisterService implements InitializingBean, DisposableBean{
	
	/*InitializingBean - bean 객체 생성 시점
	 * DisposableBean - bean 객체 소멸 시점	
	 * 인터페이스를 이용할때 사용함
	 * */
	@Autowired
	private BookDao bookDao;
	
	public BookRegisterService() { }
	
	public void register(Book book) {
		bookDao.insert(book);
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("bean 객체 생성");
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("bean 객체 소멸");
	}
}