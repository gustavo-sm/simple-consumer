package com.example.demo.services.kafka.producer.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter @Getter
@Component
@ConfigurationProperties(prefix = "producer")
public class ProducerProperties {
    private String host;
}
