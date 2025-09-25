package handlers;

import DTOs.Request;

public class ValidateBodyHandler implements RequestHandler {
    private final RequestHandler nextHandler;

    public ValidateBodyHandler(RequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    public void handle(Request request) {
        System.out.println("Validating Body handler : validating request body");
        this.nextHandler.handle(request);
    }
}
