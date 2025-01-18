package com.hariSolution.producer;

import com.hariSolution.payLoad.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@Configuration
public class KafkaJsonProducer {
    private final KafkaTemplate<String, User> template;

    public KafkaJsonProducer(KafkaTemplate<String, User> template) {
        this.template = template;
    }

    public void sendMessage( User user) {
        Message<User> message= MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC,"hari")
                .build();
        template.send(message);

    }
}
