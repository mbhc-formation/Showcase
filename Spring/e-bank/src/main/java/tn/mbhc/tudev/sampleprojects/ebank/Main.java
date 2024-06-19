package tn.mbhc.tudev.sampleprojects.ebank;

public class Main {

	public static void main(String[] args) {
		/*
		 * fontion qui repond "Hello , .... " si on lui donne un nom sinon elle repond
		 * "Hello , User " .
		 */
		Hello userWelcome = new Hello();
		String s = userWelcome.SayHello("wissal");
		System.out.println(s);
		String ssss = userWelcome.SayHello3(null);
		System.out.println(ssss);
		String sss = userWelcome.SayHello3("");
		System.out.println(sss);
		String ss = userWelcome.SayHello3(" ");
		System.out.println(ss);
	}

}

class Hello {

	public String SayHello(String Name) {

		if (Name == null || Name.isBlank())

			return "Hello USER ";

		return "Hello " + Name;

	}

	public String SayHello2(String Name) {
		return (Name == null || Name.isBlank()) ? "Hello USER 2" : "Hello 2 " + Name;
	}

	public String SayHello3(String Name) {
		StringBuilder message = new StringBuilder("Hello ");
		if (Name == null || Name.isBlank())
			message.append("USER");
		else 
			message.append(Name);
		
		return message.toString();
	}
	
}