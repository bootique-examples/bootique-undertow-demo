[![verify](https://github.com/bootique-examples/bootique-undertow-demo/actions/workflows/verify.yml/badge.svg)](https://github.com/bootique-examples/bootique-undertow-demo/actions/workflows/verify.yml)
# bootique-undertow-demo

**WARNING: the last release of Bootique that supports "bootique-undertow" is 3.0. It is currently deprecated, and will be removed from Bootique 4.0. We recommend our users to switch to Jetty, or to fork "bootique-undertow" and support it on their own.**

A simple example that explains how to start [Undertow](https://undertow.io) server integrated for [Bootique](https://bootique.io). 

*For additional help/questions about this example send a message to
[Bootique forum](https://groups.google.com/forum/#!forum/bootique-user).*

You can find different versions of framework in use at

* [2.x](https://github.com/bootique-examples/bootique-undertow-demo/tree/2.x)
* [1.x](https://github.com/bootique-examples/bootique-undertow-demo/tree/1.x)

## Prerequisites

* Java 1.8 or newer.
* Apache Maven.

## Build the Demo

Here is how to build it:

	git clone git@github.com:bootique-examples/bootique-undertow-demo.git
	cd bootique-undertow-demo
	mvn package

## Run the Demo

Now you can check the options available in your app:

    java -jar target/bootique-undertow-demo-2.0.jar
    
    Option                                              Description
    ------                                              -----------    
    -c yaml_location, --config=yaml_location            Specifies YAML config location, which can be a file path or a URL.

    -h, --help                                          Prints this message.

    -H, --help-config                                   Prints information about application modules and their configuration options.

    -s, --server                                        Starts Undertow server. 
    
Run Undertow server:

    java -jar target/bootique.undertow.demo-2.0.jar
    
Then open [http://localhost:8080/api/](http://localhost:8080/api/) to do GET/POST requests on the server.

In the example one can also find some jUnit tests.
