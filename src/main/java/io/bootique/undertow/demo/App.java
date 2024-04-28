package io.bootique.undertow.demo;

import io.bootique.Bootique;
import io.bootique.di.BQModule;
import io.bootique.di.Binder;
import io.bootique.undertow.handlers.RootHandler;
import io.undertow.server.HttpHandler;

/**
 * Entry point of application.
 */
public class App implements BQModule {

    public static void main(String[] args) {
        Bootique
                .app(args)
                .autoLoadModules()
                .module(App.class)
                .exec()
                .exit();
    }

    @Override
    public void configure(Binder binder) {

        // Provide our HttpHandler as implementation of root http handler for undertow.
        binder.bind(HttpHandler.class, RootHandler.class)
                .toProvider(RootHttpHandler.class).inSingletonScope();
    }
}
