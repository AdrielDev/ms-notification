package com.api.msnotification.service;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KafkaServiceListener {

    @Autowired
    private Consumer<String, String> kafkaConsumer;

    public void listen() {
        while (true) {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
            records.forEach(record -> {
                System.out.println("Received message: " + record.value());
            });
        }
    }
}
