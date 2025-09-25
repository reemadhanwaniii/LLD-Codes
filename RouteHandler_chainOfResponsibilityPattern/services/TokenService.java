package services;

import DTOs.Request;

public interface TokenService {
    boolean validateToken(Request request);
}
