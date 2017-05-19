package io.bootique.undertow.demo;

import com.google.inject.Binder;
import com.google.inject.Module;
import io.bootique.Bootique;
import io.bootique.undertow.UndertowModule;

public class Application implements Module {
    public static final void main(String[] args) {
        Bootique.app(args).module(UndertowModule.class).module(Application.class).run();
    }

    @Override
    public void configure(Binder binder) {
        UndertowModule.extend(binder)
                .addController(EchoRestController.class)
                .addWrapper(ApplicationExceptionHandler.class);
    }
}
