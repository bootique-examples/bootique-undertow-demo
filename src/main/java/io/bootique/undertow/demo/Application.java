package io.bootique.undertow.demo;

import io.bootique.Bootique;

/**
 * Entry point of application.
 */
public class Application {
    public static void main(String[] args) {
        Bootique
            .app(args)
            .args("--server", "--config=classpath:static.yml")
            .moduleProvider(new ApplicationModuleProvider())
            .exec()
            .exit();
    }
}
