package com.smart.Mongo.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.smart.Mongo.Model.Book;

public interface BookRepository extends MongoRepository<Book,Integer>{
	public List<Book> findByAuthorName(String name);

}
