package com.wade.resource;

import java.util.List;

import com.wade.domain.Book;


/**
 * 测试接口
 * @author wade
 *
 */
//@Path("/students")
public interface BookResource {
	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getAllBooks();
	

}