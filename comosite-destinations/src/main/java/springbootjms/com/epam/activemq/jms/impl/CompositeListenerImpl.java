package springbootjms.com.epam.activemq.jms.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import springbootjms.com.epam.activemq.jms.CompositeListener;

import javax.jms.JMSException;
import javax.jms.TextMessage;



@Slf4j
@Component
public class CompositeListenerImpl implements CompositeListener {

  @Value("${composite-example.composite-queue}")
  private String compositeQueue;

  @Value("${composite-example.forward-queue}")
  private String forwardQueue;

  @Value("${composite-example.forward-topic}")
  private String forwardTopic;



  @JmsListener(destination = "${composite-example.composite-queue}", containerFactory = "queueListenerFactory")
  public void receiveMessageFromCompositeQueue(Message jsonMessage) throws JMSException {

    TextMessage textMessage = (TextMessage) jsonMessage;
    String messageData = textMessage.getText();
    log.info("Received message: " + messageData + " from composite queue - " + compositeQueue);
  }


  @JmsListener(destination = "${composite-example.forward-queue}", containerFactory = "queueListenerFactory")
  public void receiveMessageFromForwardQueue(Message jsonMessage) throws JMSException {

    TextMessage textMessage = (TextMessage) jsonMessage;
    String messageData = textMessage.getText();
    log.info("Received message: " + messageData + " from forward queue - " + forwardQueue);
  }

  @JmsListener(destination = "${composite-example.forward-topic}", containerFactory = "topicListenerFactory")
  public void receiveMessageFromForwardTopic(Message jsonMessage) throws JMSException {

    TextMessage textMessage = (TextMessage) jsonMessage;
    String messageData = textMessage.getText();
    log.info("Received message: " + messageData + " from forward topic - " + forwardTopic);
  }

}