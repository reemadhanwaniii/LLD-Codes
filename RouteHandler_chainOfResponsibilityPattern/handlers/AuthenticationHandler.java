package handlers;

import DTOs.Request;
import services.TokenService;
import services.TokenServiceImpl;

public class AuthenticationHandler implements RequestHandler {
    private final RequestHandler nextHandler;
    private final TokenService tokenService;

    public AuthenticationHandler(RequestHandler nextHandler) {
        this.nextHandler = nextHandler;
        this.tokenService = new TokenServiceImpl();
    }
    public void handle(Request request) {
        this.tokenService.validateToken(request);
        System.out.println("Authentication handler : Authenticating the request");
        this.nextHandler.handle(request);
    }
}
