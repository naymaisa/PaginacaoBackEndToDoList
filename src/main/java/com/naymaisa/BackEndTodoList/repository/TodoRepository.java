package com.naymaisa.BackEndTodoList.repository;

import com.naymaisa.BackEndTodoList.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<Todo, String> {
}
