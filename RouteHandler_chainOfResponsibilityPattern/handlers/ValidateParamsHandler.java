package handlers;

import DTOs.Request;

public class ValidateParamsHandler implements RequestHandler {
    private final RequestHandler nextHandler;
    public ValidateParamsHandler(RequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    public void handle(Request request) {
        System.out.println("Validating params handler : validating request params");
        this.nextHandler.handle(request);
    }
}
