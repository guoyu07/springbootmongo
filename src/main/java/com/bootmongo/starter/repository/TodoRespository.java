package com.bootmongo.starter.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.bootmongo.starter.model.Todo;

@Repository
public interface TodoRespository extends MongoRepository<Todo, Integer> {

	List<Todo> findByUserId(String userId);
	
	@Query("{userId : ?0, status : ?1}")
	List<Todo> findByUserAndStatus(String userId, String status);
}
