package com.invasionofsmallcubes.poc.messaging;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;

@EnableBinding(Processor.class)
@ConditionalOnProperty(
        value = "consumer.enabled",
        havingValue = "true",
        matchIfMissing = true)
public class EnableBindingConfiguration {

}
