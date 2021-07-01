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


  @Value("${composite-example.mirrored-queue}")
  private String mirroredQueue;


  @Value("${postfix}")
  private String postfix;


  @JmsListener(destination = "${composite-example.mirrored-queue}" + "${postfix}", containerFactory = "topicListenerFactory")
  public void receiveMessageFromCompositeMirroredQueue(Message jsonMessage) throws JMSException {

    TextMessage textMessage = (TextMessage) jsonMessage;
    String messageData = textMessage.getText();
    log.info("Received message: " + messageData + " from mirror queue - " + mirroredQueue + postfix);

  }


}
