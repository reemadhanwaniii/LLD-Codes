package handlers;

import DTOs.Request;

public class ValidateBodyHandler implements RequestHandler {
    private final RequestHandler nextHandler;

    public ValidateBodyHandler(RequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    public void handle(Request request) {
//        above the next handler , whatever is written will be executed before
        System.out.println("Validating Body handler : validating request body");
        this.nextHandler.handle(request);

//        below the next handler call whatever is written will executed after
    }
}
