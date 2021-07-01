package springbootjms.com.epam.activemq.controller;


import springbootjms.com.epam.activemq.dto.User;


public interface TestController {

  void compositeQueueTest(User user);

  void virtualTopicTest(User user);
}
