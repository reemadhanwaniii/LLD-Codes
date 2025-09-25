package controllers;

import DTOs.Request;
import factory.RequestHandlerFactory;
import handlers.*;
import schema.Todo;

import java.util.List;

public class TodoController {


    private Todo createTodo(Request request) {
        RequestHandlerFactory.getHandlerForCreateTodo().handle(request);
        return new Todo();
    }
}
