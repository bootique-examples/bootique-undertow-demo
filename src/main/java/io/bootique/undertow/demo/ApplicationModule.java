package io.bootique.undertow.demo;

import io.bootique.BaseModule;
import io.bootique.di.Binder;
import io.bootique.undertow.handlers.RootHandler;
import io.undertow.server.HttpHandler;

/**
 * @author Ibragimov Ruslan
 */
public class ApplicationModule extends BaseModule {
    @Override
    public void configure(Binder binder) {

        // Provide our HttpHandler as implementation of root http handler for undertow.
        binder.bind(HttpHandler.class, RootHandler.class)
                .toProvider(RootHttpHandler.class);
    }
}
