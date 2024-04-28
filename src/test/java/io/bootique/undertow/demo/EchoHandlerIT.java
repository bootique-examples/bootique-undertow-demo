package io.bootique.undertow.demo;


import io.bootique.test.junit.BQTestFactory;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EchoHandlerIT {
    @Rule
    public BQTestFactory testFactory = new BQTestFactory();

    @Before
    public void testRuntime() {
        testFactory
            .app("--server", "--config=classpath:static.yml")
            .module(App.class)
            .run();
    }

    @Test
    public void handleGetRequest() throws Exception {
        final Content content = Request.Get("http://localhost:8080/api/")
            .execute()
            .returnContent();

        assertEquals("Hello World!", content.asString());
    }

    @Test
    public void handlePostRequest() throws Exception {
        final Content content = Request.Post("http://localhost:8080/api/Vader")
            .execute()
            .returnContent();

        assertEquals("Hello Vader!", content.asString());
    }

    @Test
    public void handleStatic() throws Exception {
        final Content content = Request.Get("http://localhost:8080/static/test.txt")
            .execute()
            .returnContent();

        assertEquals("Content", content.asString());
    }

    @Test
    public void handleException() throws Exception {
        final Content content = Request.Get("http://localhost:8080/api/exception")
            .execute()
            .returnContent();

        assertEquals("Programmatic Error", content.asString());
    }
}
