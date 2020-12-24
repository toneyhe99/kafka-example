package com.layo.kafkaexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Spring Boot app with Apache Kafka in Docker container: https://howtodoinjava.com/kafka/spring-boot-with-kafka/
 * (see https://habr.com/en/post/529222/ for kafka server setup)
 * (Apache Kafka + Zookeeper docker image selection  --- images from wurstmeister )
 *
 * 1. Open spring initializr and create spring boot application with following dependencies:
 *          Spring for Apache Kafka
 *          Spring Web
 *
 * 2. Add user/password, host:port, into application.yml file
 *
 * 3. KafKaProducerService class uses autowired KafkaTemplate to send message to configured topic name.
 *    Similarly, KafKaConsumerService class uses @KafkaListener to receive messages from configured topic name.
 *
 * 4. Test
 *    Message post : http://localhost:9000/kafka/publish?message=Alphabet
 *    Observe the console logs:
 *          KafKaProducerService  : Message sent -> Alphabet
 *          KafKaConsumerService  : Message recieved -> Alphabet
 *
 * Reference detail: https://www.w3cschool.cn/apache_kafka/apache_kafka_simple_producer_example.html
 */
@SpringBootApplication
public class KafkaExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(KafkaExampleApplication.class, args);
    }
}
