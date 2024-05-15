package tn.mbhc.tudev.designpatterns.singleton;

/**
 * Example of implementation of the singelton pattern. <br>
 * This implementation is thread-safe.
 */
public final class MySingleton {

	/*
	 * SingletonHolder is loaded on the first execution of Singleton.getInstance()
	 * or the first access to SingletonHolder.INSTANCE, not before.
	 */
	private static class SingletonHolder {
		private static final MySingleton INSTANCE = new MySingleton();
	}

	/**
	 * Renturns the instance of this {@link MySingleton}.
	 * 
	 * @return
	 */
	public static final MySingleton getInstance() {
		return SingletonHolder.INSTANCE;
	}

	/*
	 * Private constructor to prevent instanciation
	 */
	private MySingleton() {
		// Singelton class should not be instanciated
	}

}
