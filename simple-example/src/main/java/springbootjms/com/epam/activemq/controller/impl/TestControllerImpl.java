package springbootjms.com.epam.activemq.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springbootjms.com.epam.activemq.controller.TestController;
import springbootjms.com.epam.activemq.dto.User;
import springbootjms.com.epam.activemq.jms.Producer;


@RestController
@RequiredArgsConstructor
public class TestControllerImpl implements TestController {

  private final Producer producer;


  @PostMapping("/queue")
  public void compositeQueueTest(@RequestBody User user) {
    producer.sendMessageToQueue(user.toString());
  }


  @PostMapping("/topic")
  public void virtualTopicTest(@RequestBody User user) {
    producer.sendMessageToTopic(user.toString());
  }

}
