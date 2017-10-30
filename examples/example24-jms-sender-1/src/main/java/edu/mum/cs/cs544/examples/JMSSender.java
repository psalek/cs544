package edu.mum.cs.cs544.examples;
import javax.jms.*;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;


public class JMSSender {
    private JmsTemplate jmsTemplate;
    
    public void send(final Person person) {
        jmsTemplate.send(new MessageCreator() {
              public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(person);
              }
        });            
        System.out.println("Sending message with person object : " + person.getFirstName()+" "+person.getLastName());
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

}
