package com.wade.resource.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wade.domain.Book;
import com.wade.resource.BookResource;


@Path("/books")
public class BookResourceImpl  implements BookResource{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<Book> getAllBooks() {
		logger.info("浏览器获取了所有Book信息");
		Map<Integer, Book> books = new HashMap<Integer, Book>();
		Integer index = 0;
		books.put(index, new Book(index++, "book01"));
		
		List<Book> lists = new ArrayList<Book>();
		lists.addAll(books.values());
		return lists;
	}

}
