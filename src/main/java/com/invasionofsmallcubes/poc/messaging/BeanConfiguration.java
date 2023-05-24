package com.invasionofsmallcubes.poc.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.batch.BatchingStrategy;
import org.springframework.amqp.rabbit.batch.SimpleBatchingStrategy;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.BatchingRabbitTemplate;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.TaskScheduler;

import java.util.function.Consumer;

import static java.util.stream.IntStream.range;

@Configuration
public class BeanConfiguration {

    private final Logger logger = LoggerFactory.getLogger(BeanConfiguration.class);

    @Bean
    public BatchingRabbitTemplate template(CachingConnectionFactory cf, TaskScheduler taskScheduler) {
        BatchingStrategy batchingStrategy = new SimpleBatchingStrategy(10, 1000000, 1000);
        return new BatchingRabbitTemplate(cf, batchingStrategy, taskScheduler);
    }

    @Bean
    public Consumer<Message<LogMessage>> input() {
        return msg -> {
            System.out.println(msg);
            logger.info("New Message: {}", msg.getPayload().getMessage());
        };
    }
}
