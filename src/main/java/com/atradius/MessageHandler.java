package com.atradius;

import com.atradius.examples.Tweet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageHandler {
    @KafkaListener(topics = "${spring.kafka.topics}")
    void processPosition(final Tweet msg) {
        log.info("Message received: {}", msg);
    }
}
