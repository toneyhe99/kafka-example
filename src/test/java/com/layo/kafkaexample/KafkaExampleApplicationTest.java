package com.layo.kafkaexample;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;

import java.io.IOException;

@SpringBootTest
@EmbeddedKafka(count = 1,ports = {9092})
class KafkaExampleApplicationTest {
    @Test
    void contextLoads()throws IOException { }
}