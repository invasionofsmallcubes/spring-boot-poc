package com.invasionofsmallcubes.poc.web;

import com.invasionofsmallcubes.poc.messaging.LogMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

@RestController
public class PingController {

    private Logger logger = LoggerFactory.getLogger(PingController.class);

    private Source source;

    PingController(Source source) {
        this.source = source;
    }

    @RequestMapping("/ping")
    public String ping() {
        return "Pong";
    }

    @RequestMapping("/woosh")
    public String woosh() {
        IntStream.range(0, 601).forEach(i -> {
            logger.info("Sending message...{}", i);
            source.output().send(MessageBuilder.withPayload(new LogMessage("I am a message: " + i)).build());
        });
        return "OK";
    }
}
