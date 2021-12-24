package com.smart.Mongo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smart.Mongo.Model.Book;
import com.smart.Mongo.Repository.BookRepository;
import com.smart.Mongo.Request.CreateRequest;

@RestController
public class BookController {
	@Autowired
	BookRepository bookRepository;
	@GetMapping("/getBooks")
	public List<Book> getBooks(){
		return bookRepository.findAll();
	}
	@PostMapping("/insertBook")
	public void insertBook(@RequestBody CreateRequest createRequest) {
		Book b=new Book(createRequest.getName(),createRequest.getAuthorName(),createRequest.getCost(),createRequest.get_count());
		bookRepository.save(b);
	}
	@GetMapping("/getBookByAuthor/{name}")
	public List<Book> getBooksByAuthorName(@PathVariable(value="name") String name){
		return bookRepository.findByAuthorName(name);
	}
}
