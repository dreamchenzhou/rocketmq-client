package com.wefree.mqclient;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

/**
 * @author yong.chen
 * @date 2020/6/4
 */

public class Producer {
    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("dream-producer");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();
        for(int i=0;i<10;i++){
            Message message = new Message();
            message.setTopic("MyQuickStartTopic");
            message.setTags("tabA");
            message.setBody(("Hello World"+i).getBytes("UTF-8"));
            producer.send(message);
        }
    }
}
