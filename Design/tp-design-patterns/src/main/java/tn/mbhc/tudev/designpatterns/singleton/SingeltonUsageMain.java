package tn.mbhc.tudev.designpatterns.singleton;

/**
 * Main class for demonstrating singelton and multiple objects instances usage.
 */
public class SingeltonUsageMain {

	public static void main(String[] args) {
		
		System.out.println("----- Singelton # unique object instance example ----- ");
		System.out.println();
		
		System.out.println("Calling singelton getInstance() method several times");
		System.out.println("--> should always return the same 'unique' instance (see object's reference)");
		System.out.println(MySingleton.getInstance());
		System.out.println(MySingleton.getInstance());
		System.out.println(MySingleton.getInstance());
		System.out.println(MySingleton.getInstance());

		System.out.println();
		System.out.println("----- Multiple # object (of the same class) instances example ----- ");
		System.out.println();
		
		System.out.println("Creating multiple instances of a non singelton class");
		System.out.println("--> should show different instances (see objects references)");
		System.out.println(NonSingelton.getInstance());
		System.out.println(NonSingelton.getInstance());
		System.out.println(NonSingelton.getInstance());
		System.out.println(NonSingelton.getInstance());
	}

}
