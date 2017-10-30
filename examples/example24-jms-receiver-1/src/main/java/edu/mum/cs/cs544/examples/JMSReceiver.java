package edu.mum.cs.cs544.examples;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;


public class JMSReceiver implements MessageListener {

    public void onMessage(Message message){
    	ObjectMessage objmessage = (ObjectMessage)message;
    	try {
			Person person = (Person)objmessage.getObject();
			System.out.println(this.getClass().getSimpleName() + " receives message with person object : " + person.getFirstName()+" "+person.getLastName());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

