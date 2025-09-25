package factory;

import handlers.*;

public class RequestHandlerFactory {
    public  static RequestHandler getHandlerForCreateTodo() {
        RequestHandler handler = new ValidateParamsHandler(
                new ValidateBodyHandler(
                        new AuthenticationHandler(
                                new AuthorizationHandler(
                                        new FinishingHandler()
                                )
                        )
                )
        );
        return handler;
    }

    public static RequestHandler getHandlerForUpdateTodo() {
        return new ValidateParamsHandler(
                new ValidateBodyHandler(
                        new AuthenticationHandler(
                                new AuthorizationHandler(
                                        new FinishingHandler()
                                )
                        )
                )
        );
    }
}
