package io.bootique.undertow.demo;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;
import io.bootique.undertow.handlers.RootHandler;
import io.undertow.server.HttpHandler;

/**
 * @author Ibragimov Ruslan
 */
public class ApplicationModule implements Module {
    @Override
    public void configure(Binder binder) {

        // Provide our HttpHandler as implementation of root http handler for undertow.
        binder.bind(HttpHandler.class).annotatedWith(RootHandler.class)
            .toProvider(RootHttpHandler.class).in(Singleton.class);
    }
}
