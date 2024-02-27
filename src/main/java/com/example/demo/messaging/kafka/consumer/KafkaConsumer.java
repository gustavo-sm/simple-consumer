package com.example.demo.messaging.kafka.consumer;

import com.example.demo.services.ProcessPayload;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
@Service
public class KafkaConsumer {
    @KafkaListener(topics = "topicotest")
    public void eventListener(@Payload ConsumerRecord<String, String> payloadRecord, Acknowledgment ack)  {
        String receivedPayload = payloadRecord.value();
        ProcessPayload.processPayload(receivedPayload);
        ack.acknowledge();
    }
}
