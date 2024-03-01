package com.example.demo.messaging.kafka.consumer;

import com.example.demo.services.ProcessPayload;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    @Autowired
    private ProcessPayload processPayload;
    @KafkaListener(topics = "topicotest")
    public void eventListener(@Payload ConsumerRecord<String, String> payloadRecord, Acknowledgment ack)  {
        System.out.println(payloadRecord);
        String receivedPayload = payloadRecord.value();this.processPayload.processPayload(receivedPayload);
        ack.acknowledge();
    }
}
