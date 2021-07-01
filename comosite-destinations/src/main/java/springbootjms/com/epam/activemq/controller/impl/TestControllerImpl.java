package springbootjms.com.epam.activemq.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springbootjms.com.epam.activemq.controller.TestController;
import springbootjms.com.epam.activemq.dto.User;
import springbootjms.com.epam.activemq.jms.CompositeProducer;
import springbootjms.com.epam.activemq.jms.VirtualTopicProducer;


@RestController
@RequiredArgsConstructor
public class TestControllerImpl implements TestController {

  private final CompositeProducer compositeProducer;

  private final VirtualTopicProducer virtualTopicProducer;

  @PostMapping("/composite-queue")
  public void compositeQueueTest(@RequestBody User user) {
    compositeProducer.sendMessage(user.toString());
  }


  @PostMapping("/virtual-topic")
  public void virtualTopicTest(@RequestBody User user) {
    virtualTopicProducer.sendMessage(user.toString());
  }

}
