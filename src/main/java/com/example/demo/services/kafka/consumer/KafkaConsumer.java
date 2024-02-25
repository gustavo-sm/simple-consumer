package com.example.demo.services.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.boot.json.JsonParser;
@Service
public class KafkaConsumer {
    @KafkaListener(topics = "topicotest")
    public void eventListener(@Payload ConsumerRecord<String, String> payloadRecord, Acknowledgment ack) {
        System.out.println(payloadRecord.value());
        ack.acknowledge();
    }
}
