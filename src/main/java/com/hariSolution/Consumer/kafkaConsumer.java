package com.hariSolution.Consumer;

import com.hariSolution.payLoad.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service

public class kafkaConsumer {
    private static final Logger log = LoggerFactory.getLogger(kafkaConsumer.class);

    //@KafkaListener(topics = "hari",groupId = "myGroup")
    public void consumeMessage(String message) {
        log.info(format("consume message %s",message));

    }

    @KafkaListener(topics = "hari",groupId = "myGroup")
    public void consumeJsonMessage(User user) {
        log.info(format("consume message %s",user.toString()));

    }
}
