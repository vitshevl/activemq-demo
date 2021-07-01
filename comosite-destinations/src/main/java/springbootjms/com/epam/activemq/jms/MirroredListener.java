package springbootjms.com.epam.activemq.jms;

import org.apache.activemq.Message;

import javax.jms.JMSException;


public interface MirroredListener {

  void receiveMessageFromCompositeMirroredQueue(Message jsonMessage) throws JMSException;


}
