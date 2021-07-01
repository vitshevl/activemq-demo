package springbootjms.com.epam.activemq.jms.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import springbootjms.com.epam.activemq.jms.CompositeProducer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;


@Slf4j
@Component
@RestController
public class CompositeProducerImpl implements CompositeProducer {

  @Autowired
  @Qualifier("queueJmsTemplate")
  private JmsTemplate jmsTemplate;

  @Value("${composite-example.composite-queue}")
  private String compositeQueue;


  public void sendMessage(String messageText) {

    log.info("Sending message " + messageText + " to queue - " + compositeQueue);

    jmsTemplate.send(compositeQueue, new MessageCreator() {

      public Message createMessage(Session session) throws JMSException {
        TextMessage message = session.createTextMessage();
        message.setText(messageText);
        return message;
      }
    });
  }
}

