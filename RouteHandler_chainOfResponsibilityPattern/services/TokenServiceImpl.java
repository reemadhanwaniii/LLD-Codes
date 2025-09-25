package services;

import DTOs.Request;

public class TokenServiceImpl implements TokenService {


    @Override
    public boolean validateToken(Request request) {
        System.out.println("Validating Token");

        /**
         * -> fetches token from header
         * -> validate token using the key
         * -> if token is not valid return not authenticated
         */
        return true;
    }
}
