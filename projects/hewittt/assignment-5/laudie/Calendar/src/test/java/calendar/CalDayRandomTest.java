package calendar;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;


/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
		private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
		private static final int NUM_TESTS = 100;

    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void randomtest()  throws Throwable {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 System.out.println("Start testing...");

		 try {
			 LinkedList<Appt> listAppts = new LinkedList<Appt>();
			 TimeTable timeTable = new TimeTable();
			 LinkedList<CalDay> calDays = new LinkedList<CalDay>();

			 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				 long randomseed = System.currentTimeMillis(); //10
				 Random random = new Random(randomseed);

				 int startHour = ValuesGenerator.getRandomIntBetween(random, -24, 30);
				 int startMinute = ValuesGenerator.getRandomIntBetween(random, -20, 80);
				 int startDay = ValuesGenerator.getRandomIntBetween(random, -20, 40);
				 int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startYear = ValuesGenerator.getRandomIntBetween(random, -1000, 1000);

				 String title = "Birthday Party";

				 String description = null;
				 if (startYear > 0)
					 description = "This is my birthday party.";

				 //Construct a new Appointment object with the initial data
				 Appt appt = new Appt(startHour,
						 startMinute,
						 startDay,
						 startMonth,
						 startYear,
						 title,
						 description);

				 listAppts.add(appt);
                 if(appt.getValid() == false) {
                     for (int i = 0; i < calDays.size(); i++)
                         calDays.get(i).addAppt(appt);
                 }
				 startHour = ValuesGenerator.getRandomIntBetween(random, 0, 23);
				 appt.setStartHour(startHour);
				 startMinute = ValuesGenerator.getRandomIntBetween(random, 0, 59);
				 appt.setStartMinute(startMinute);
				 startDay = ValuesGenerator.getRandomIntBetween(random, 28, 35);
				 appt.setStartDay(startDay);
				 startDay = ValuesGenerator.getRandomIntBetween(random, 0, 28);
				 appt.setStartDay(startDay);
				 startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 appt.setStartMonth(startMonth);
				 startYear = ValuesGenerator.getRandomIntBetween(random, 2018, 2019);
                 appt.setStartYear(startYear);

				 listAppts.add(appt);

				 Calendar rightnow = Calendar.getInstance();
				 //current month/year/date is today
				 int thisMonth = rightnow.get(Calendar.MONTH);
				 int thisYear = rightnow.get(Calendar.YEAR);
				 int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

				 GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
				 GregorianCalendar nextYear = (GregorianCalendar) today.clone();
				 nextYear.add(Calendar.YEAR, 1);

				calDays = timeTable.getApptRange(listAppts, today, nextYear);
				 for (int i = 0; i < calDays.size(); i++)
					 calDays.get(i).addAppt(appt);
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				 if ((iteration % 10000) == 0 && iteration != 0)
					 System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);
			 }

		 } catch (NullPointerException e) {

		 }

		 System.out.println("Done testing...");

	 }
}

