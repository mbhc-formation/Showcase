package tn.mbhc.tudev.designpatterns.singleton;

/**
 * Non singelton class for demonstration
 */
public final class NonSingelton {

	private NonSingelton() {
	}

	/**
	 * Returns a new instance of this class.
	 * 
	 * @return
	 */
	public static NonSingelton getInstance() {
		return new NonSingelton();
	}
}
