package springbootjms.com.epam.activemq.jms.impl;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import springbootjms.com.epam.activemq.jms.MirroredProducer;


@Slf4j
@Component
public class MirroredProducerImpl implements MirroredProducer {

  @Autowired
  @Qualifier("queueJmsTemplate")
  private JmsTemplate jmsTemplate;

  @Value("${composite-example.mirrored-queue}")
  private String mirroredQueue;


  public void sendMessage(String messageText) {

    log.info("Sending message " + messageText + " to queue - " + mirroredQueue);

    jmsTemplate.convertAndSend(mirroredQueue, messageText);

  }
}
