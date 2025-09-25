package handlers;

import DTOs.Request;

public class FinishingHandler implements RequestHandler{
    public void handle(Request request){
        System.out.println("Finishing Handler");
    }
}
