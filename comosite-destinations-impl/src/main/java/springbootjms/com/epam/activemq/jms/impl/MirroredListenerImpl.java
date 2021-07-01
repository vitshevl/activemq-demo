package springbootjms.com.epam.activemq.jms.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import springbootjms.com.epam.activemq.jms.MirroredListener;

import javax.jms.JMSException;
import javax.jms.TextMessage;


@Slf4j
@Component
public class MirroredListenerImpl implements MirroredListener {


  @Value("${composite-example.composite-queue}")
  private String compositeQueue;

  @Value("${composite-example.forward-queue}")
  private String forwardQueue;

  @Value("${postfix}")
  private String postfix;


  @JmsListener(destination = "${composite-example.composite-queue}" + "${postfix}", containerFactory = "topicListenerFactory")
  public void receiveMessageFromCompositeMirroredTopic(Message jsonMessage) throws JMSException {

    TextMessage textMessage = (TextMessage) jsonMessage;
    String messageData = textMessage.getText();
    log.info("Received message: " + messageData + " from mirror topic - " + compositeQueue + postfix);

  }


  @JmsListener(destination = "${composite-example.forward-queue}" + "${postfix}", containerFactory = "topicListenerFactory")
  public void receiveMessageFromForwardMirroredTopic(Message jsonMessage) throws JMSException {

    TextMessage textMessage = (TextMessage) jsonMessage;
    String messageData = textMessage.getText();
    log.info("Received message: " + messageData + " from mirror topic - " + forwardQueue + postfix);

  }

}
