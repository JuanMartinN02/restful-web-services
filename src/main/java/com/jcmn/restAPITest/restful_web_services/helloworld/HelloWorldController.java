package com.jcmn.restAPITest.restful_web_services.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// REST API
@RestController
public class HelloWorldController {

    // /hello-world returns "Hello World"
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    // /hello-world-bean returns "Hello World" as JSON
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

    // Path parameters
    // /users/{id of user}/to-do/{id of to-do} => /users/2/to-do/345
    // /hello-world/path_variable/{name} => /hello-world/path_variable/Jose
    @GetMapping(path = "/hello-world-bean/path_variable/{name}")
    public HelloWorldBean helloWorldPath(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello %s", name));
    }

}
