package springbootjms.com.epam.activemq.jms;

import org.apache.activemq.Message;

import javax.jms.JMSException;


public interface MirroredListener {

  void receiveMessageFromCompositeMirroredTopic(Message jsonMessage) throws JMSException;

  void receiveMessageFromForwardMirroredTopic(Message jsonMessage) throws JMSException;

}
