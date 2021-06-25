package springbootjms.com.epam.activemq.jms;

/**
 * CompositeProducerImpl.
 *
 * @author Viktor_Shevliagin
 */
public interface CompositeProducer {

  void sendMessage(String message);

}
