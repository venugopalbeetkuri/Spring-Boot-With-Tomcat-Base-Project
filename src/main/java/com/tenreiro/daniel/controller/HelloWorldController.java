package com.tenreiro.daniel.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller that just says "Hello World"
 *
 * @author Daniel Tenreiro - dtenreiroarcos@gmail.com
 */
@RestController
public class HelloWorldController {

    /**
     * Hello World
     *
     * @return A ResponseEntity with the message "Hello World"
     */
    @RequestMapping(value = "/hello_world", method = RequestMethod.GET)
    public ResponseEntity<String> helloWorld() {
        return new ResponseEntity<String>("Hello World", HttpStatus.OK);
    }
}
