package com.layo.kafkaexample.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
//@ConditionalOnProperty(value = "example.kafka.consumer-enabled", havingValue = "true") --> will disable this class when the property is false!
public class AcknowledgeConsumerService {

    /**
     *  This topic need acknowledgment (the producer waits for an acknowledgment from kafka once the leader receives the message.)
     *
     * Acknowledgements relate to Kafka’s durability guarantees. When publishing a message, the producer has to pick from one of three options:
     *      acks=0: Don't require an acknowledgement from the leader.
     *      acks=1: Require one acknowledgement from the leader, being the persistence of the record to its local log.
     *      acks=all: Require the leader to receive acknowledgements from all in-sync replicas.
     *  When acks=0, the producer is effectively operating in a fire-and-forget mode.
     */
    @KafkaListener(topics = {"INPUT_DATA"})
    public void consume(final @Payload String message,
                        final @Header(KafkaHeaders.OFFSET) Integer offset,
                        final @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        final @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                        final @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                        final @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long ts,
                        final Acknowledgment acknowledgment
    ) {
        log.info(String.format("#### -> Consumed message -> TIMESTAMP: %d\n%s\noffset: %d\nkey: %s\npartition: %d\ntopic: %s", ts, message, offset, key, partition, topic));
        acknowledgment.acknowledge();
    }
}
