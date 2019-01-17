/*
 * Copyright (c) 2018, 2018, Travel and/or its affiliates. All rights reserved.
 * TRAVEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package com.daas.dms.config;

import com.daas.dms.works.DmsMessageListener;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author flysLi
 * @ClassName ConsumerConfigs
 * @Decription TODO
 * @Date 2019/1/16 18:00
 * @Version 1.0
 */
@Configuration
@EnableKafka
public class KafkaConfigs {
    @Bean
    public Map<String,Object> consumerConfigs(){
        Map<String,Object> props = new HashMap<>(10);
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"114.116.24.215:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "0");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, 100);
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return props;
    }

    @Bean
    ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }

    @Bean
    public DmsMessageListener myMessageListener() {
        return new DmsMessageListener();
    }

    //消费者容器配置信息
    @Bean
    public ContainerProperties containerProperties() {
        Pattern topicPattern = Pattern.compile(".*[tT]opic.*"); //匹配满足正则的topic
        ContainerProperties containerProperties = new ContainerProperties(topicPattern);//订阅满足正则表达式的topic
        containerProperties.setMessageListener(myMessageListener());//订阅的topic的消息用myMessageListener去处理
        return containerProperties;
    }

    @Bean
    public KafkaMessageListenerContainer<String, String> kafkaMessageListenerContainer() {
        return new KafkaMessageListenerContainer<>(consumerFactory(), containerProperties());
    }
}
