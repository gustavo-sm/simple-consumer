package com.example.demo.services.kafka.consumer;


import org.apache.kafka.clients.consumer.ConsumerInterceptor;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

import java.util.Map;

public class Interceptor implements ConsumerInterceptor<String, String> {


    @Override
    public void configure(Map<String, ?> configs) {
    }

    @Override
    public ConsumerRecords<String, String> onConsume(ConsumerRecords<String, String> records) {
        System.out.println("Tamanho dataframe: "+ records.count());
        return records;
    }

    @Override
    public void onCommit(Map<TopicPartition, OffsetAndMetadata> map) {
        for (Map.Entry<TopicPartition, OffsetAndMetadata> entry : map.entrySet()) {
            System.out.println("Acked! Partition: " + entry.getKey() + ", Offset:" + entry.getValue().offset());
        }
    }

    @Override
    public void close() {
    }

}