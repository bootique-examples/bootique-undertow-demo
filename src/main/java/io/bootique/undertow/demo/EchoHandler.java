package io.bootique.undertow.demo;

import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;

public class EchoHandler {
    public void get(HttpServerExchange exchange) {
        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
        exchange.getResponseSender().send("Hello World!");
    }

    public void getException(HttpServerExchange exchange) {
        throw new RuntimeException("Programmatic Error");
    }

    public void post(HttpServerExchange exchange) {
        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
        exchange.getResponseSender().send("Hello " + exchange.getQueryParameters().get("name").getFirst() + "!");
    }
}
