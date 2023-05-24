package com.invasionofsmallcubes.poc.web;

import com.invasionofsmallcubes.poc.messaging.LogMessage;
import org.springframework.amqp.rabbit.core.BatchingRabbitTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.stream.IntStream.range;
import static org.springframework.messaging.support.MessageBuilder.withPayload;

@RestController
public class PingController {

    private final BatchingRabbitTemplate template;

    PingController(BatchingRabbitTemplate template) {
        this.template = template;
    }

    @RequestMapping("/ping")
    public String ping() {
        return "Pong";
    }

    @RequestMapping("/woosh")
    public String woosh() {
        range(0, 601).forEach(i ->
                template.convertAndSend("input-in-0", "input-in-0.rbgh303", withPayload(new LogMessage("I am a message: " + i)).build()));
        return "OK";
    }
}
