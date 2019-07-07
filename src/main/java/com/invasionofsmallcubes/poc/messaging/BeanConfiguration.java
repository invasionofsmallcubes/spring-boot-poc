package com.invasionofsmallcubes.poc.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.support.MessageBuilder;

import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;

@Configuration
public class BeanConfiguration {

    private Logger logger = LoggerFactory.getLogger(BeanConfiguration.class);

    @Bean
    @ConditionalOnProperty(
            value = "consumer.enabled",
            havingValue = "true",
            matchIfMissing = true)
    public Producer realProducer(Source source) {
        return () -> range(0, 601).forEach(i -> {
            logger.info("Sending message...{}", i);
            try {
                source.output().send(MessageBuilder.withPayload(new LogMessage("I am a message: " + i)).build());
            } catch (Exception e) {
                logger.error("Problem sending message", e);
            }
        });
    }

    @Bean
    @ConditionalOnProperty(
            value = "consumer.enabled",
            havingValue = "false")
    public Producer noopProducer() {
        return () -> {
        };
    }
}
