package tn.mbhc.tudev.cleancode.birthdaycheck.provider;

import java.time.LocalDate;

/**
 * Date provider interface markup.
 */
public interface DateProvider {

	/**
	 * Returns the date generated by the provider.
	 * 
	 * @return
	 */
	LocalDate getDate();

}
