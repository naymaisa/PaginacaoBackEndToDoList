package com.naymaisa.BackEndTodoList.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Todo {
    @Id
    private String id;
    private String task;
    private boolean completed;
}
