package com.daas.dms;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class DaasdataApplication {

	@KafkaListener(topics = "test")
	public void receive(ConsumerRecord<?, ?> consumerRecord) {
		System.out.println("topic是:" + consumerRecord.topic() + "\tkey:" + consumerRecord.key() + "\tvalue:" + consumerRecord.value());
	}
	public static void main(String[] args) {
		SpringApplication.run(DaasdataApplication.class, args);
	}

}

