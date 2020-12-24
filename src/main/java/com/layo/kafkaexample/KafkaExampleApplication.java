package com.layo.kafkaexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Spring Boot app with Apache Kafka in Docker container (more detail Doc on https://habr.com/en/post/529222/)
 * (Apache Kafka + Zookeeper docker image selection  --- images from wurstmeister, see https://hub.docker.com/r/wurstmeister/kafka )
 *
 * 1. Open spring initializr and create spring boot application with following dependencies:
 *          Spring for Apache Kafka
 *          Spring Web
 *
 * 2. Add application.yml file
 *
 * 3. KafKa Producer Service class uses autowired KafkaTemplate to send message to configured topic name.
 *    Similarly, KafKa Consumer Service class uses @KafkaListener to receive messages from configured topic name.
 *
 * 4. Copy The 2 files below, into /etc/kafka/ folder
 *          docker-compose.yml
 *          kafka_server_jaas.conf
 *      In that directory call:    docker-compose up -d
 *
 *  5. Start this app and see console
 */
@EnableScheduling
@SpringBootApplication
public class KafkaExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(KafkaExampleApplication.class, args);
    }
}
