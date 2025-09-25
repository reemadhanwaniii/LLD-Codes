package handlers;

import DTOs.Request;

public class AuthenticationHandler implements RequestHandler {
    private final RequestHandler nextHandler;
    public AuthenticationHandler(RequestHandler nextHandler) {
        this.nextHandler = nextHandler;;
    }
    public void handle(Request request) {
        System.out.println("Authentication handler : Authenticating the request");
        this.nextHandler.handle(request);
    }
}
