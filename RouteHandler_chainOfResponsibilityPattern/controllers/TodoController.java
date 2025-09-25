package controllers;

import DTOs.Request;
import handlers.*;
import schema.Todo;

import java.util.List;

public class TodoController {

//    private Todo createTodo(Request request) {
//       Execute initial handlers
//        /**
//         * Here it is violation SOLID,
//         * Controller is deciding/calling handler , ideally one handler should call another handler
//         * Violating SRP controller is handling handler/middleware logic
//         */
//       List<RequestHandler> handlerList;
//           for(RequestHandler handler : handlerList) {
//               handler.handle(request);
//           }
//       Return a new Todo
//        return new Todo();
//    }

    private Todo createTodo(Request request) {
        RequestHandler handler = new ValidateParamsHandler(
                new ValidateBodyHandler(
                        new AuthenticationHandler(
                                new AuthorizationHandler(
                                        new FinishingHandler()
                                )
                        )
                )
        );
//problem with above approach we are doing lot of new object creation violating factory pattern
        return new Todo();
    }
}
