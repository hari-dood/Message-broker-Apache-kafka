package com.hariSolution.producer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    private static  final Logger log = LoggerFactory.getLogger(KafkaProducer.class);

    public void sendMessage(String message) {
        log.info(format("Sending message to topic %s", message));
        kafkaTemplate.send("hari", message);
    }
}
