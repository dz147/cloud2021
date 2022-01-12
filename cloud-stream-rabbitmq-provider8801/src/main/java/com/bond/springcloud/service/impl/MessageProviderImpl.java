package com.bond.springcloud.service.impl;

import com.bond.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author Stephen Zhang
 * @Date 2022/1/12 21:37
 * @Version 1.0
 * @EnableBinding 定义消息的推送管道
 */
@EnableBinding(Source.class)
@Slf4j
public class MessageProviderImpl implements IMessageProvider {

    /**
     * 消息发送管道
     */
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info(serial);
        return "success";
    }
}
