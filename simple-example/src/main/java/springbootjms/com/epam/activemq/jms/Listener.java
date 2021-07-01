package springbootjms.com.epam.activemq.jms;

import org.apache.activemq.Message;

import javax.jms.JMSException;



public interface Listener {

  void receiveMessageFromQueue(Message jsonMessage) throws JMSException;

  void receiveMessageFromForwardTopic(Message jsonMessage) throws JMSException;

}
