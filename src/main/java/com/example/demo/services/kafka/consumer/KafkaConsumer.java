package com.example.demo.services.kafka.consumer;

import com.example.demo.helpers.ProcessPayload;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
@Service
public class KafkaConsumer {
    @KafkaListener(topics = "topicotest")
    public void eventListener(@Payload ConsumerRecord<String, String> payloadRecord, Acknowledgment ack) throws JsonProcessingException {
        String receivedPayload = payloadRecord.value();
        ProcessPayload.processPayload(receivedPayload);
        ack.acknowledge();
    }
}
