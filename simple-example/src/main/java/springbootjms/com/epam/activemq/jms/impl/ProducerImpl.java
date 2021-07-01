package springbootjms.com.epam.activemq.jms.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import springbootjms.com.epam.activemq.jms.Producer;


@Slf4j
@Component
@RestController
public class ProducerImpl implements Producer {

  @Autowired
  @Qualifier("queueJmsTemplate")
  private JmsTemplate queueJmsTemplate;

  @Autowired
  @Qualifier("topicJmsTemplate")
  private JmsTemplate topicJmsTemplate;

  @Value("${simple-example.topic}")
  private String topic;

  @Value("${simple-example.queue}")
  private String queue;


  public void sendMessageToQueue(String messageText) {

    log.info("Sending message " + messageText + " to queue - " + queue);

    queueJmsTemplate.convertAndSend(queue, messageText);
  }


  public void sendMessageToTopic(String messageText) {

    log.info("Sending message " + messageText + " to  topic - " + topic);

    topicJmsTemplate.convertAndSend(topic, messageText);
  }


}

