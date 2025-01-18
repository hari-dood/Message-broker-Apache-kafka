package com.hariSolution.controller;

import com.hariSolution.payLoad.User;
import com.hariSolution.producer.KafkaJsonProducer;
import com.hariSolution.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")

public class kafkaController {

    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer jsonProducer;

    public kafkaController(KafkaProducer kafkaProducer, KafkaJsonProducer jsonProducer) {
        this.kafkaProducer = kafkaProducer;
        this.jsonProducer = jsonProducer;
    }

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        kafkaProducer.sendMessage(message);
        return new ResponseEntity<>("message has been send"+message, HttpStatus.OK);
    }

    @PostMapping("/json")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {
        jsonProducer.sendMessage(user);
        return new ResponseEntity<>("json message has been send"+user.toString(), HttpStatus.OK);
    }
}
