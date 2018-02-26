package calendar;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;



import static org.junit.Assert.*;



/**
 * Random Test Generator  for Appt class.
 */

public class ApptRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS = 100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
	public static String RandomSelectMethod(Random random) {
		String[] methodArray = new String[]{"setTitle", "setRecurrence"};// The list of the of methods to be tested in the Appt class

		int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

		return methodArray[n]; // return the method name
	}

	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
	public static int RandomSelectRecur(Random random) {
		int[] RecurArray = new int[]{Appt.RECUR_BY_WEEKLY, Appt.RECUR_BY_MONTHLY, Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

		int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
		return RecurArray[n]; // return the value of the  appointments to recur
	}

	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
	public static int RandomSelectRecurForEverNever(Random random) {
		int[] RecurArray = new int[]{Appt.RECUR_NUMBER_FOREVER, Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

		int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
		return RecurArray[n]; // return appointments to recur forever or Never recur
	}

	/**
	 * Generate Random Tests that tests Appt Class.
	 */
	@Test
	public void randomtest() throws Throwable {

		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		System.out.println("Start testing...");

		try {
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed = System.currentTimeMillis(); //10
				//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);

				int startHour = ValuesGenerator.RandInt(random);
				int startMinute = ValuesGenerator.RandInt(random);
				int startDay = ValuesGenerator.RandInt(random);
				;
				int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int startYear = ValuesGenerator.RandInt(random);
				String title = "Birthday Party";
				String description = "This is my birthday party.";
				//Construct a new Appointment object with the initial data
				Appt appt = new Appt(startHour,
						startMinute,
						startDay,
						startMonth,
						startYear,
						title,
						description);
				if (!appt.getValid()) continue;
				for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					if (methodName.equals("setTitle")) {
						String newTitle = (String) ValuesGenerator.getString(random);
						appt.setTitle(newTitle);
					} else if (methodName.equals("setRecurrence")) {
						int sizeArray = ValuesGenerator.getRandomIntBetween(random, 0, 8);
						int[] recurDays = ValuesGenerator.generateRandomArray(random, sizeArray);
						int recur = ApptRandomTest.RandomSelectRecur(random);
						int recurIncrement = ValuesGenerator.RandInt(random);
						int recurNumber = ApptRandomTest.RandomSelectRecurForEverNever(random);
						appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
					}
				}

				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if ((iteration % 10000) == 0 && iteration != 0)
					System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);

			}
		} catch (NullPointerException e) {

		}

		System.out.println("Done testing...");
	}


	@Test
	public void randomtest01() throws Throwable {

		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		System.out.println("Start testing...");

		try {
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed = System.currentTimeMillis(); //10
				//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);

				int startHour = ValuesGenerator.RandInt(random) % 30;
				if (startHour % 2 == 0)    //Make start hour negative
					startHour = -startHour;
				else if (startHour % 3 == 0 || startHour % 5 == 0)    //Make start hour greater than 23 hrs
					startHour += 21;
				int startMinute = ValuesGenerator.RandInt(random);
				if (startMinute % 2 == 0)    //Make start minute negative
					startMinute = -startMinute;
				else if (startMinute % 3 == 0 || startMinute % 5 == 0)    //Make start minute greater than 23 hrs
					startMinute += 57;
				int startDay = ValuesGenerator.getRandomIntBetween(random, 28, 40);

				int startMonth = ValuesGenerator.getRandomIntBetween(random, -5, 20);
			//	if (startMonth % 2 == 1)
			//		startMonth = -startMonth;
				int startYear = ValuesGenerator.RandInt(random);
				String title = "Birthday Party";
				String description = "This is my birthday party.";
				//Construct a new Appointment object with the initial data
				Appt appt = null;
				try {
					appt = new Appt(startHour,
							startMinute,
							startDay,
							startMonth,
							startYear,
							title,
							description);
				} catch(ArrayIndexOutOfBoundsException m){}

				startHour = ValuesGenerator.getRandomIntBetween(random, 0, 23);
				appt.setStartHour(startHour);
				startMinute = ValuesGenerator.getRandomIntBetween(random, 0, 59);
				appt.setStartMinute(startMinute);
				startDay = ValuesGenerator.getRandomIntBetween(random, 28, 35);
				appt.setStartDay(startDay);
				startDay = ValuesGenerator.getRandomIntBetween(random, 0, 28);
				appt.setStartDay(startDay);
				startMonth = ValuesGenerator.getRandomIntBetween(random, -20, 0);
					try{appt.setStartMonth(startMonth);}
					catch (ArrayIndexOutOfBoundsException m){}
                startMonth = ValuesGenerator.getRandomIntBetween(random, 20, 40);
                try{appt.setStartMonth(startMonth);}
                catch (ArrayIndexOutOfBoundsException m){}
				startYear = ValuesGenerator.getRandomIntBetween(random, -5000, 5000);
				    try{appt.setStartYear(startYear);}
				    catch(ArrayIndexOutOfBoundsException m){}


				if (!appt.getValid()) continue;
				for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					if (methodName.equals("setTitle")) {
						String newTitle = (String) ValuesGenerator.getString(random);
						appt.setTitle(newTitle);
					} else if (methodName.equals("setRecurrence")) {
						int sizeArray = ValuesGenerator.getRandomIntBetween(random, 0, 8);
						int[] recurDays = ValuesGenerator.generateRandomArray(random, sizeArray);
							if(recurDays.length % 2 == 0)
								recurDays = null;
						int recur = ApptRandomTest.RandomSelectRecur(random);
						int recurIncrement = ValuesGenerator.RandInt(random);
						int recurNumber = ApptRandomTest.RandomSelectRecurForEverNever(random);
						appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
					}
				}

				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if ((iteration % 10000) == 0 && iteration != 0)
					System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);

			}
		} catch (NullPointerException e) {

		}

		System.out.println("Done testing...");

	}
}