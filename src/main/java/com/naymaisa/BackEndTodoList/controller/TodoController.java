package com.naymaisa.BackEndTodoList.controller;

import com.naymaisa.BackEndTodoList.model.Todo;
import com.naymaisa.BackEndTodoList.repository.TodoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos/api")
@CrossOrigin(origins = "*")
public class TodoController {

    private final TodoRepository repository;

    public TodoController(TodoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Todo> getAll(){
        return repository.findAll();
    }

    @GetMapping("/paginated")
    public Page<Todo> getPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("task").ascending());
        return repository.findAll(pageable);
    }

    @PostMapping
    public  Todo create(@RequestBody Todo todo){
        return  repository.save((todo));
    }
    @DeleteMapping("/{id}")
    public void  delete(@PathVariable String id){
        repository.deleteById(id);
    }
    @PutMapping("/{id}")
    public Todo update(@PathVariable String id, @RequestBody Todo todo){
        todo.setId(id);
        return repository.save(todo);
    }
}
