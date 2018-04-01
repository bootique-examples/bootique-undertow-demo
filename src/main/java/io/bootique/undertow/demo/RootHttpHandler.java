package io.bootique.undertow.demo;

import com.google.inject.Inject;
import com.google.inject.Provider;
import io.undertow.server.HttpHandler;
import io.undertow.server.RoutingHandler;
import io.undertow.server.handlers.PathHandler;
import io.undertow.server.handlers.resource.ClassPathResourceManager;
import io.undertow.server.handlers.resource.ResourceHandler;
import io.undertow.server.handlers.resource.ResourceManager;

/**
 * Creates root handler as combination of another handlers and handler wrappers.
 *
 * @author Ibragimov Ruslan
 */
public class RootHttpHandler implements Provider<HttpHandler> {
    private final EchoHandler echoHandler;
    private final ApplicationExceptionHandler applicationExceptionHandler;

    @Inject
    public RootHttpHandler(EchoHandler echoHandler, ApplicationExceptionHandler applicationExceptionHandler) {
        this.echoHandler = echoHandler;
        this.applicationExceptionHandler = applicationExceptionHandler;
    }

    @Override
    public HttpHandler get() {
        final RoutingHandler routingHandler = new RoutingHandler()
            .get("/", echoHandler::get)
            .get("/exception", echoHandler::getException)
            .post("/{name}", echoHandler::post);

        final ResourceManager resourceManager = new ClassPathResourceManager(
            RootHttpHandler.class.getClassLoader(),
            "public/"
        );

        final ResourceHandler resourceHandler = new ResourceHandler(resourceManager);

        final PathHandler pathHandler = new PathHandler(42)
            .addPrefixPath("/", resourceHandler)
            .addPrefixPath("/api", routingHandler);

        return applicationExceptionHandler.wrap(pathHandler);
    }
}
