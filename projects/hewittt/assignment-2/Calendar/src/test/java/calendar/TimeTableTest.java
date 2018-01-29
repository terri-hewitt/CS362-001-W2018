package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 Calendar rightnow = Calendar.getInstance();
		 //current month/year/date is today
		 int thisMonth = rightnow.get(Calendar.MONTH);
		 int thisYear = rightnow.get(Calendar.YEAR);
		 int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

		 GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		 GregorianCalendar nextMonth = (GregorianCalendar)today.clone();
		 nextMonth.add(Calendar.MONTH,1);

		 TimeTable timeTable=new TimeTable();
		 LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		 calDays = timeTable.getApptRange(listAppts, today, nextMonth);

		 assertEquals(true, calDays.get(0).getAppts().isEmpty());

                 /*Add an appointment to calendar*/
		 int startHour=13;
		 int startMinute=10;
		 int startDay=thisDay;
		 int startMonth=thisMonth;
		 int startYear=thisYear;
		 String title="Party";
		 String description="This is my party.";
		 //Construct a new Appointment object with the initial data
		 Appt appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);

		 int[] recurDaysArr={2,3,4};
		 appt.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);

		 listAppts.add(appt);
		 calDays = timeTable.getApptRange(listAppts, today, nextMonth);

		 assertEquals(3, calDays.size());

	 }
	 @Test
	  public void test02()  throws Throwable  {
		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 Calendar rightnow = Calendar.getInstance();
		 //current month/year/date is today
		 int thisMonth = rightnow.get(Calendar.MONTH);
		 int thisYear = rightnow.get(Calendar.YEAR);
		 int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

		 GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		 GregorianCalendar nextMonth = (GregorianCalendar)today.clone();
		 nextMonth.add(Calendar.MONTH,1);

		 TimeTable timeTable=new TimeTable();
		 LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		 calDays = timeTable.getApptRange(listAppts, today, nextMonth);

		 assertEquals(true, calDays.get(0).getAppts().isEmpty());

                 /*Add an appointment to calendar*/
		 int startHour=13;
		 int startMinute=10;
		 int startDay=10;
		 int startMonth=2;
		 int startYear=thisYear;
		 String title="Party";
		 String description="This is my party.";
		 //Construct a new Appointment object with the initial data
		 Appt appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);

		 listAppts.add(appt);

		 /*Add an appointment to calendar*/
		 startHour=17;
		 startMinute=10;
		 startDay=10;
		 startMonth=2;
		 startYear=thisYear;
		 title="Party 2";
		 description="This is my party 2.";
		 //Construct a new Appointment object with the initial data
		 Appt appt2 = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);

		 listAppts.add(appt2);
		 calDays = timeTable.getApptRange(listAppts, today, nextMonth);

		 assertEquals("Party", listAppts.get(0).getTitle());
		 assertEquals("Party 2", listAppts.get(1).getTitle());

		 int[] pv = {0, 1};
		 timeTable.permute(listAppts, pv);

		 assertEquals("Party 2", listAppts.get(0).getTitle());
		 assertEquals("Party", listAppts.get(1).getTitle());
	 }

	 @Test
	public void test03()  throws Throwable {
		Calendar rightnow = Calendar.getInstance();
		//current month/year/date is today
		int thisMonth = rightnow.get(Calendar.MONTH);
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar) today.clone();
		GregorianCalendar nextTenDays = (GregorianCalendar) today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH, 1);
		nextTenDays.add(Calendar.DAY_OF_MONTH, 10);

		TimeTable timeTable = new TimeTable();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = timeTable.getApptRange(listAppts, today, tomorrow);

		assertEquals(true, calDays.get(0).getAppts().isEmpty());

                 /*Add an appointment to calendar*/
		int startHour = 20;
		int startMinute = 10;
		int startDay = 28;
		int startMonth = 2;
		int startYear = 2018;
		String title = "Party";
		String description = "This is my party.";
		//Construct a new Appointment object with the initial data
		Appt appt2 = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);

		 int[] recurDaysArr={1,2,3,4,5};
		 appt2.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
		 listAppts.add(appt2);

		 calDays = timeTable.getApptRange(listAppts, today, nextTenDays);
		 assertEquals(10, calDays.size());
		// assertEquals("Second date specified is not  before the first date specified.", timeTable.getApptRange(listAppts, nextFiveDays, today));
		 assertEquals(1000, appt2.getRecurNumber());
		 assertEquals(true, listAppts.getFirst().isRecurring());
		 assertEquals(true, listAppts.getLast().isRecurring());

		assertEquals(true, appt2.getValid());
		 assertEquals( true, listAppts.contains(appt2));
		timeTable.deleteAppt(listAppts, appt2);
		assertEquals(false, listAppts.contains(appt2));
	}
	@Test
	public void test04()  throws Throwable {
		Calendar rightnow = Calendar.getInstance();
		//current month/year/date is today
		int thisMonth = rightnow.get(Calendar.MONTH);
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar) today.clone();
		GregorianCalendar nextTenDays = (GregorianCalendar) today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH, 1);
		nextTenDays.add(Calendar.DAY_OF_MONTH, 10);

		TimeTable timeTable = new TimeTable();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = timeTable.getApptRange(listAppts, today, tomorrow);

		assertEquals(true, calDays.get(0).getAppts().isEmpty());

                 /*Add an appointment to calendar*/
		int startHour = 20;
		int startMinute = 10;
		int startDay = 28;
		int startMonth = 2;
		int startYear = 2018;
		String title = "Party";
		String description = "This is my party.";
		//Construct a new Appointment object with the initial data
		Appt appt2 = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);

		int[] recurDaysArr = {1, 2, 3, 4, 5};
		appt2.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
		listAppts.add(appt2);

		calDays = timeTable.getApptRange(listAppts, today, nextTenDays);
	//	assertNotEquals(calDays,timeTable.getApptRange(listAppts, nextTenDays, today));
	}
	@Test
	public void test05()  throws Throwable {
		Calendar rightnow = Calendar.getInstance();
		//current month/year/date is today
		int thisMonth = rightnow.get(Calendar.MONTH);
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar) today.clone();
		GregorianCalendar nextTenDays = (GregorianCalendar) today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH, 1);
		nextTenDays.add(Calendar.DAY_OF_MONTH, 10);

		TimeTable timeTable = new TimeTable();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();

                 /*Add an appointment to calendar*/
		int startHour = 20;
		int startMinute = 10;
		int startDay = 25;
		int startMonth = 1;
		int startYear = 2018;
		String title = "Party";
		String description = "This is my party.";
		//Construct a new Appointment object with the initial data
		Appt appt2 = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);
		int vp[] = {1,2,3,4,5,6};
		appt2.setRecurrence(vp, 2, 2, 10);
		listAppts.add(appt2);

		calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		calDays = timeTable.getApptRange(listAppts, tomorrow, today);
		//	assertNotEquals(calDays,timeTable.getApptRange(listAppts, nextTenDays, today));
	}
	@Test
	public void test06()  throws Throwable {
		Calendar rightnow = Calendar.getInstance();
		//current month/year/date is today
		int thisMonth = rightnow.get(Calendar.MONTH);
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar) today.clone();
		GregorianCalendar fewDaysAgo = (GregorianCalendar) today.clone();
		GregorianCalendar nextTenDays = (GregorianCalendar) today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH, 1);
		fewDaysAgo.add(Calendar.DAY_OF_MONTH, -5);
		nextTenDays.add(Calendar.DAY_OF_MONTH, 10);

		TimeTable timeTable = new TimeTable();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();

                 /*Add an appointment to calendar*/
		int startHour = 20;
		int startMinute = 10;
		int startDay = 23;
		int startMonth = 1;
		int startYear = 2018;
		String title = "Something else";
		String description = "This is some event.";
		//Construct a new Appointment object with the initial data

		Appt appt0 = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);
		/*Add an appointment to calendar*/
		startHour = 20;
		startMinute = 100;
		startDay = -12;
		startMonth = 1;
		startYear = 2018;
		title = "Party";
		description = "This is my party.";
		listAppts.add(appt0);
		//Construct a new Appointment object with the initial data
		timeTable.deleteAppt(listAppts, null);
		timeTable.deleteAppt(listAppts, appt0);

		Appt appt1 = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);
		/*Add an appointment to calendar*/
		startHour = 20;
		startMinute = 10;
		startDay = 25;
		startMonth = 1;
		startYear = 2018;
		title = "Party";
		description = "This is my party.";
		//Construct a new Appointment object with the initial data
		timeTable.deleteAppt(listAppts, null);
		timeTable.deleteAppt(null, appt1);

		Appt appt2 = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);
		int list[] = {1,2,3,4,5,6};
		assertEquals(list, appt2.getRecurDays());
		appt2.setRecurrence(list, 2, 2, 10);
		timeTable.getApptRange(listAppts, fewDaysAgo, tomorrow);

		listAppts.add(appt1);
		listAppts.add(appt2);
		listAppts.add(appt1);
		listAppts.add(appt2);
		timeTable.deleteAppt(listAppts, appt2);
		timeTable.deleteAppt(listAppts, appt0);
		timeTable.permute(listAppts, list);
			//	assertNotEquals(calDays,timeTable.getApptRange(listAppts, nextTenDays, today));
	}
	//add more unit tests as you needed
}
