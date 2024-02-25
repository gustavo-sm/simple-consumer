package com.example.demo.services.kafka.consumer.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Setter @Getter
@Component
@ConfigurationProperties(prefix = "consumer")
public class ConsumerProperties {
    private String host;
    private String groupid;
    private Boolean autocommit;
    private String autooffsetreset;
    private String ackmode;
}
