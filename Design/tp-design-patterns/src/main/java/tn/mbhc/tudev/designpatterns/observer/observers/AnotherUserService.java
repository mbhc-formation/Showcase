package tn.mbhc.tudev.designpatterns.observer.observers;

import java.util.Observable;
import java.util.Observer;

import tn.mbhc.tudev.designpatterns.observer.observable.User;

public class AnotherUserService implements Observer {

	// @formatter:off

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof User) {
			User user = (User) o;
			System.out.println(String.format("[AnotherUserService] intercepted a notification of user update [new type value = '%s']", 
					user.getUserType()));
		}
	}

	// @formatter:on
}
