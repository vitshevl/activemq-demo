package springbootjms.com.epam.activemq.jms;

import org.apache.activemq.Message;

import javax.jms.JMSException;


public interface DurNonDurListener {

  void receiveMessageFromTopicByDurableSubscriber(Message jsonMessage) throws JMSException;

  void receiveMessageFromTopicByNonDurableSubscriber(Message jsonMessage) throws JMSException;

}
