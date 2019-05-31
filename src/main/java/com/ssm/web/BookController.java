package com.ssm.web;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssm.base.BaseControllerTest;
import com.ssm.entity.Book;
import com.ssm.service.impl.BookServiceImpl;

/**
 * 
 * @author 
 */
// 配置事务的回滚,对数据库的增删改都会回滚,便于测试用例的循环利用
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@Controller
public class BookController extends BaseControllerTest{

	@Resource
	private BookServiceImpl bookService;
	
	@RequestMapping("/hello")
	public String list(@RequestParam(value="bookId",required=false)String bookId,ModelMap model) throws Exception {
		Book book = new Book();
		if(!"".equals(bookId)&&bookId!=null){
			book = bookService.getById(Integer.parseInt(bookId));
			System.out.println("====="+bookId);
			model.addAttribute("message", book.getName());
		}
		System.out.println("====="+book.getName());
		return "hello";
	}

}
