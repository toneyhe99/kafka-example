package com.layo.kafkaexample.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafKaConsumerService {
    @KafkaListener(topics = AppConstants.TOPIC_NAME, groupId = AppConstants.GROUP_ID)  //group managed listener is used
    public void consume(String message) {
        log.info(String.format("Message recieved -> %s", message));
        //as ack-mode is manual(set in property), so this consume is not commited (not callled acknowledgment.acknowledge())
        //so the kafka will still wait this message to pull by others!
    }
}
