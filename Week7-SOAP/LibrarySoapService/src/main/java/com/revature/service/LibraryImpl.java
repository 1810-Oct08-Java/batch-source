package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.revature.models.Book;

@WebService(endpointInterface="com.revature.service.Library")
public class LibraryImpl implements Library	{
	
	private List<Book> bookList = new ArrayList<>();
	
	public LibraryImpl() {
		bookList.add(new Book("Cat's Cradle","Kurt Vonnegut",1963));
		bookList.add(new Book("Time Cat","Lloyd Alexander",1996));
		bookList.add(new Book("To Kill a Mockingbird","Harper Lee",1960));
	}

	@Override
	public List<Book> getAllBooks() {
		return this.bookList;
	}

	@Override
	public String addBook(Book book) {
		this.bookList.add(book);
		return book.getName()+" added to the libarary";
	}

}
