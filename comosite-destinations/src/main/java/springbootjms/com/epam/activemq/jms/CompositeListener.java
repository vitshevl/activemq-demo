package springbootjms.com.epam.activemq.jms;

import org.apache.activemq.Message;

import javax.jms.JMSException;



public interface CompositeListener {

  void receiveMessageFromForwardQueue(Message jsonMessage) throws JMSException;

  void receiveMessageFromCompositeQueue(Message jsonMessage) throws JMSException;

  void receiveMessageFromForwardTopic(Message jsonMessage) throws JMSException;

}
