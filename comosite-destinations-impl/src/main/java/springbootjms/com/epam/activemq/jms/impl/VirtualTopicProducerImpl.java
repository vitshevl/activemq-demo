package springbootjms.com.epam.activemq.jms.impl;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import springbootjms.com.epam.activemq.jms.VirtualTopicProducer;



@Slf4j
@Component
@RestController
public class VirtualTopicProducerImpl implements VirtualTopicProducer {

  @Autowired
  @Qualifier("topicJmsTemplate")
  private  JmsTemplate jmsTemplate;

  @Value("${virtual-topic-example.topic}")
  private String virtualTopic;


  public void sendMessage(String messageText) {

    log.info("Sending message " + messageText + " to virtual topic - " + virtualTopic);

    jmsTemplate.convertAndSend("VirtualTopic.MY-SUPER-TOPIC", messageText);
  }

}