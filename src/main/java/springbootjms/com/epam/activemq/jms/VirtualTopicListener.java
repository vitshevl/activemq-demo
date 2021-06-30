package springbootjms.com.epam.activemq.jms;

import org.apache.activemq.Message;

import javax.jms.JMSException;


public interface VirtualTopicListener {


  void receiveMessageFromTopic_1 (Message jsonMessage) throws JMSException;

  void receiveMessageFromTopic_2 (Message jsonMessage) throws JMSException;

}
