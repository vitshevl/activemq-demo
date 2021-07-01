package springbootjms.com.epam.activemq.jms;




public interface Producer {

  void sendMessageToQueue(String message);

  void sendMessageToTopic(String message);

}
