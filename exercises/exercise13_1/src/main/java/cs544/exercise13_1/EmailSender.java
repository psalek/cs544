package cs544.exercise13_1;

public class EmailSender implements IEmailSender {
	String outgoingMailServer = "smtp.acme.com";

	public String getOutgoingMailServer() {
		return outgoingMailServer;
	}

	public void sendEmail (String email, String message){
		System.out.println("EmailSender: sending '"+message+"' to "+email );
	}
}
