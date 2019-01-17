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
package com.daas.dms.works;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

/**
 * @author flysLi
 * @ClassName DmsMessageListener
 * @Decription TODO
 * @Date 2019/1/16 18:03
 * @Version 1.0
 */
public class DmsMessageListener implements MessageListener<String, String> {
    @Override
    public void onMessage(ConsumerRecord<String, String> stringStringConsumerRecord) {
        String topic = stringStringConsumerRecord.topic();
        System.out.println("topic的分区:" + String.valueOf(stringStringConsumerRecord.partition()));
        System.out.println("offset:" + String.valueOf(stringStringConsumerRecord.offset()));
        System.out.println("接收到的消息:[" + topic + "]\t" + stringStringConsumerRecord.value());
    }
}
