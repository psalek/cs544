package cs544.exercise23_1.server;

public class GreetingService implements IGreeting {
	public String getMessage(Person person) {
		System.out.println("RMI Server object receiving person with name "
				+ person.getFirstName() + " " + person.getLastName());
		return "Hello " + person.getFirstName() + " " + person.getLastName();
	}
}