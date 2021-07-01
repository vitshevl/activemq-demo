package springbootjms.com.epam.activemq.jms.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import springbootjms.com.epam.activemq.jms.Listener;

import javax.jms.JMSException;
import javax.jms.TextMessage;


@Slf4j
@Component
public class ListenerImpl implements Listener {

  @Value("${simple-example.queue}")
  private String queue;

  @Value("${simple-example.topic}")
  private String topic;


  @JmsListener(destination = "${simple-example.queue}", containerFactory = "queueListenerFactory")
  public void receiveMessageFromQueue(Message jsonMessage) throws JMSException {

    TextMessage textMessage = (TextMessage) jsonMessage;
    String messageData = textMessage.getText();
    log.info("Received message: " + messageData + " from queue - " + queue);
  }


  @JmsListener(destination = "${simple-example.topic}", containerFactory = "topicNonDurListenerFactory")
  public void receiveMessageFromTopic_1(Message jsonMessage) throws JMSException {

    TextMessage textMessage = (TextMessage) jsonMessage;
    String messageData = textMessage.getText();
    log.info("Received message: " + messageData + " from topic - " + topic + " by the first subscriber.");
  }

  @JmsListener(destination = "${simple-example.topic}", containerFactory = "topicNonDurListenerFactory")
  public void receiveMessageFromTopic_2(Message jsonMessage) throws JMSException {

    TextMessage textMessage = (TextMessage) jsonMessage;
    String messageData = textMessage.getText();
    log.info("Received message: " + messageData + " from topic - " + topic + " by the second subscriber.");
  }

}