package tn.mbhc.tudev.cleancode.birthdaycheck.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import tn.mbhc.tudev.cleancode.birthdaycheck.component.BirthdayCheck;
import tn.mbhc.tudev.cleancode.birthdaycheck.provider.impl.InMemoryFixedDateProvider;
import tn.mbhc.tudev.cleancode.birthdaycheck.provider.impl.SystemDateProvider;
import tn.mbhc.tudev.cleancode.birthdaycheck.provider.impl.InitialInputDateProvider;

public class BirthdayCheckMain {

	/*
	 * Formatter used for output (for main examples only)
	 */
	private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("--------- Comparing given birthday dates using multiple date providers -------------"); 

		// Bithday date used for comparison
		LocalDate birthDay = LocalDate.of(2024, 1, 1);
		
		System.out.println();
		System.out.println("-- 1 -- using SystemDateProvider class --");
		
		SystemDateProvider sysDateProvider = new SystemDateProvider();
		BirthdayCheck birthDayCheckWithSysDate = new BirthdayCheck(sysDateProvider);
		System.out.println(String.format("System date is : %s", format(sysDateProvider.getDate())));
		System.out.println(String.format("Birthday is : %s", format(birthDay)));
		System.out.println(String.format("Dates are equal : %s", birthDayCheckWithSysDate.isMyBirthday(birthDay)));

		System.out.println();
		System.out.println("-- 2 -- using InMemoryFixedDateProvider class --");
		
		InMemoryFixedDateProvider inMemoryFixedDateProvider = new InMemoryFixedDateProvider();
		BirthdayCheck birthDayCheckWithFixedDate = new BirthdayCheck(inMemoryFixedDateProvider);
		System.out.println(String.format("In-memory fixed date is : %s", format(inMemoryFixedDateProvider.getDate())));
		System.out.println(String.format("Birthday is : %s", format(birthDay)));
		System.out.println(String.format("Dates are equal : %s", birthDayCheckWithFixedDate.isMyBirthday(birthDay)));
		
		System.out.println();
		System.out.println("-- 3 -- using InitialInputDateProvider class --");
		
		InitialInputDateProvider initialInputDateProvider = new InitialInputDateProvider(LocalDate.of(2024, 1, 1));
		BirthdayCheck birthDayCheckWithInitialInputDate = new BirthdayCheck(initialInputDateProvider);
		System.out.println(String.format("In-memory fixed date is : %s", format(initialInputDateProvider.getDate())));
		System.out.println(String.format("Birthday is : %s", format(birthDay)));
		System.out.println(String.format("Dates are equal : %s", birthDayCheckWithInitialInputDate.isMyBirthday(birthDay)));
		
		System.out.println();
		System.out.println("--------- End of Comparison -------------"); 
	}

	/**
	 * Format the given date using the dd-MM-yyyy default pattern.
	 * @param dateToFormat
	 * @return
	 */
	private static String format(final LocalDate dateToFormat) {
		return DTF.format(dateToFormat);
	}

}
