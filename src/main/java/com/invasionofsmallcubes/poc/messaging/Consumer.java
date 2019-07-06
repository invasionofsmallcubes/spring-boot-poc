package com.invasionofsmallcubes.poc.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    private Logger logger = LoggerFactory.getLogger(Consumer.class);

    @StreamListener(Processor.INPUT)
    public void enrichLogMessage(Message<LogMessage> log) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("New Message: {}", log.getPayload().getMessage());
    }

}
