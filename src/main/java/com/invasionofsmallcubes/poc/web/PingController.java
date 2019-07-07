package com.invasionofsmallcubes.poc.web;

import com.invasionofsmallcubes.poc.messaging.Producer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    private Producer producer;

    PingController(Producer producer) {
        this.producer = producer;
    }

    @RequestMapping("/ping")
    public String ping() {
        return "Pong";
    }

    @RequestMapping("/woosh")
    public String woosh() {
        producer.send();
        return "OK";
    }
}
