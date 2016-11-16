package com.example;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {
	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    	
    @RequestMapping(method = {
            RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Greeting sayHello(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}
