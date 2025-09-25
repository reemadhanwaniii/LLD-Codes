package handlers;

import DTOs.Request;

public class AuthorizationHandler implements RequestHandler {
    private final RequestHandler nextHandler;
    public AuthorizationHandler(RequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    public void handle(Request request) {
        System.out.println("Authorization handler : Authorizing the request");
        this.nextHandler.handle(request);
    }
}
