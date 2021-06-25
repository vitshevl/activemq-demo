package springbootjms.com.epam.activemq.controller;


import springbootjms.com.epam.activemq.dto.User;

/**
 * TestController.
 *
 * @author Viktor_Shevliagin
 */
public interface TestController {

  void compositeQueueTest(User user);
}
