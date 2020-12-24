package com.layo.kafkaexample.controller;

import com.layo.kafkaexample.service.KafKaProducerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaProducerController {
    private final KafKaProducerService kafKaProducerService;

    public KafkaProducerController(KafKaProducerService kafKaProducerService) {
        this.kafKaProducerService = kafKaProducerService;
    }

    @PostMapping("publish")
    public void sendMessageToKafkaTopic(@RequestParam String message){
        kafKaProducerService.sendMessage(message);
        try{
            kafKaProducerService.sendAndGet(); //set a time stamp with acknowledge
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
