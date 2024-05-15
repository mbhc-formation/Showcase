package tn.mbhc.tudev.designpatterns.observer;

import tn.mbhc.tudev.designpatterns.observer.observable.User;
import tn.mbhc.tudev.designpatterns.observer.observable.User.Type;
import tn.mbhc.tudev.designpatterns.observer.observers.AnotherUserService;
import tn.mbhc.tudev.designpatterns.observer.observers.UserService;

/**
 * Main class which illustrates usage of Observer pattern.
 */
public class ObesrverPatternApplication {

	public static void main(String[] args) {
		
		// Business service that will observe changes of the user object 
		UserService observerServiceForUser = new UserService();
		
		// Another business service that will observe changes of the user object
		AnotherUserService anotherUserService = new AnotherUserService();
		
		// User object to be observed
		User observedUser = new User("AdminUserTest", Type.USER);
		
		// Attach observers to the created user
		observedUser.addObserver(observerServiceForUser);
		observedUser.addObserver(anotherUserService);
		
		// We change a field of the observed user 
		System.out.println("INFO - Created User : " + observedUser);
		System.out.println("INFO - Update the user type to trigger observers");
		observedUser.changeType(Type.ADMIN);
	}
	
}
