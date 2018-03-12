package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class TimeTableTest {

	@Test
	public void test01() throws Throwable {
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		Calendar rightnow = Calendar.getInstance();
		//current month/year/date is today
		int thisMonth = rightnow.get(Calendar.MONTH);
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

		GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		GregorianCalendar nextMonth = (GregorianCalendar) today.clone();
		nextMonth.add(Calendar.MONTH, 1);

		TimeTable timeTable = new TimeTable();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = timeTable.getApptRange(listAppts, today, nextMonth);

		assertEquals(true, calDays.get(0).getAppts().isEmpty());

                 /*Add an appointment to calendar*/
		int startHour = 13;
		int startMinute = 10;
		int startDay = thisDay;
		int startMonth = thisMonth;
		int startYear = thisYear;
		String title = "Party";
		String description = "This is my party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);

		int[] recurDaysArr = {2, 3, 4};
		appt.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);

		listAppts.add(appt);
		calDays = timeTable.getApptRange(listAppts, today, nextMonth);

		assertEquals(31, calDays.size());

	}

	@Test
	public void test02() throws Throwable {
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		Calendar rightnow = Calendar.getInstance();
		//current month/year/date is today
		int thisMonth = rightnow.get(Calendar.MONTH);
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

		GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		GregorianCalendar nextMonth = (GregorianCalendar) today.clone();
		nextMonth.add(Calendar.MONTH, 1);

		TimeTable timeTable = new TimeTable();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = timeTable.getApptRange(listAppts, today, nextMonth);

		assertEquals(true, calDays.get(0).getAppts().isEmpty());

                 /*Add an appointment to calendar*/
		int startHour = 13;
		int startMinute = 10;
		int startDay = 10;
		int startMonth = 2;
		int startYear = thisYear;
		String title = "Party";
		String description = "This is my party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);

		listAppts.add(appt);

		 /*Add an appointment to calendar*/
		startHour = 17;
		startMinute = 10;
		startDay = 10;
		startMonth = 2;
		startYear = thisYear;
		title = "Party 2";
		description = "This is my party 2.";
		//Construct a new Appointment object with the initial data
		Appt appt2 = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);

		listAppts.add(appt2);
		calDays = timeTable.getApptRange(listAppts, today, nextMonth);

		assertEquals("Party", listAppts.get(0).getTitle());
		assertEquals("Party 2", listAppts.get(1).getTitle());

		int[] pv = {0, 1};
		timeTable.permute(listAppts, pv);

		//	 assertEquals("Party 2", listAppts.get(0).getTitle());
		//	 assertEquals("Party", listAppts.get(1).getTitle());
	}

	@Test
	public void test03() throws Throwable {
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
		assertEquals(10, calDays.size());
		// assertEquals("Second date specified is not  before the first date specified.", timeTable.getApptRange(listAppts, nextFiveDays, today));
		assertEquals(1000, appt2.getRecurNumber());
		assertEquals(true, listAppts.getFirst().isRecurring());
		assertEquals(true, listAppts.getLast().isRecurring());

		assertEquals(true, appt2.getValid());
		assertEquals(true, listAppts.contains(appt2));
		timeTable.deleteAppt(listAppts, appt2);
		//	assertEquals(false, listAppts.contains(appt2));
	}

	@Test
	public void test04() throws Throwable {
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
	public void test05() throws Throwable {
		Calendar rightnow = Calendar.getInstance();
		//current month/year/date is today
		int thisMonth = rightnow.get(Calendar.MONTH);
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar) today.clone();
		GregorianCalendar nextTenMonths = (GregorianCalendar) today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH, 1);
		nextTenMonths.add(Calendar.MONTH, 10);

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
		int vp[] = {1, 2, 3, 4, 5, 6};

		listAppts.add(appt2);
		calDays = timeTable.getApptRange(listAppts, today, nextTenMonths);

		appt2.setRecurrence(null, 1, 2, Appt.RECUR_BY_WEEKLY);
		listAppts.add(appt2);

		calDays = timeTable.getApptRange(listAppts, today, nextTenMonths);
		appt2.setRecurrence(vp, 2, 2, Appt.RECUR_BY_WEEKLY);
		listAppts.add(appt2);

		calDays = timeTable.getApptRange(listAppts, today, nextTenMonths);
		appt2.setRecurrence(vp, 1, 2, Appt.RECUR_BY_WEEKLY);
		listAppts.add(appt2);
		calDays = timeTable.getApptRange(listAppts, today, nextTenMonths);

		appt2.setRecurrence(vp, 1, 2, Appt.RECUR_BY_MONTHLY);
		listAppts.add(appt2);
		calDays = timeTable.getApptRange(listAppts, today, nextTenMonths);

		appt2.setRecurrence(vp, 1, 2, Appt.RECUR_BY_YEARLY);
		listAppts.add(appt2);
		calDays = timeTable.getApptRange(listAppts, today, nextTenMonths);

		//	calDays = timeTable.getApptRange(listAppts, tomorrow, today);
		//	assertNotEquals(calDays,timeTable.getApptRange(listAppts, nextTenDays, today));
	}

	@Test
	public void test06() throws Throwable {
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
        assertEquals(1,timeTable.getApptRange(listAppts, today, tomorrow).size());

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
		int list[] = {1, 2, 3, 4, 5, 6};
		//	assertEquals(list, appt2.getRecurDays());
		appt2.setRecurrence(list, 2, 2, Appt.RECUR_BY_WEEKLY);
		timeTable.getApptRange(listAppts, fewDaysAgo, tomorrow);

		listAppts.add(appt1);
		listAppts.add(appt2);
		listAppts.add(appt1);
		listAppts.add(appt2);
		timeTable.deleteAppt(listAppts, appt2);
		timeTable.deleteAppt(listAppts, appt0);
		assertEquals(1,timeTable.getApptRange(listAppts, today, tomorrow).size());
		//	assertEquals(false, listAppts.contains(appt2));
//		timeTable.permute(listAppts, list);
		//	assertNotEquals(calDays,timeTable.getApptRange(listAppts, nextTenDays, today));
	}

	@Test
	public void test07() throws Throwable {
		Calendar rightnow = Calendar.getInstance();
		//current month/year/date is today
		int thisMonth = rightnow.get(Calendar.MONTH);
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

		LinkedList<Appt> listAppts = new LinkedList<Appt>();
        GregorianCalendar aWhileAgo = new GregorianCalendar(thisYear, 1, 1);
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
        listAppts.add(appt0);
		/*Add an appointment to calendar*/
		startHour = 20;
		startMinute = 100;
		startDay = -12;
		startMonth = 1;
		startYear = 2018;
		title = "Party";
		description = "This is my party.";

		//Construct a new Appointment object with the initial data
	//	timeTable.deleteAppt(listAppts, );
	//	assertNotEquals(null, timeTable.deleteAppt(listAppts, appt0));

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
		assertEquals(null, timeTable.deleteAppt(listAppts, null));
		assertEquals(null, timeTable.deleteAppt(null, appt1));

		Appt appt2 = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);

		startDay = thisDay;
		startMonth = thisMonth;
		startYear = thisYear;
		Appt appt3 = new Appt(startHour,
                startMinute,
                startDay,
                startMonth,
                startYear,
                title,
                description);
		int list[] = {1, 2, 3, 4, 5, 6};
		//	assertEquals(list, appt2.getRecurDays());
		appt2.setRecurrence(list, 2, 2, Appt.RECUR_BY_WEEKLY);
		timeTable.getApptRange(listAppts, fewDaysAgo, tomorrow);

        calDays = timeTable.getApptRange(listAppts, aWhileAgo, tomorrow);
		calDays.get(0).addAppt(appt1);
		assertEquals(false, calDays.get(0).getAppts().contains(appt1));
        listAppts.add(appt1);
		listAppts.add(appt2);
        calDays.get(0).addAppt(appt2);
		listAppts.add(appt3);
        calDays.get(0).addAppt(appt3);
        assertTrue(calDays.get(0).getAppts().contains(appt3));
		listAppts.add(appt2);
        calDays.get(0).addAppt(appt2);
        assertTrue(calDays.get(0).getAppts().contains(appt2));
		listAppts.add(appt1);
        calDays.get(0).addAppt(appt1);

		assertEquals(3, listAppts.indexOf(appt3));
        assertEquals(1, calDays.get(0).getAppts().indexOf(appt3));

		//listAppts.sort(startDay);

		try{
		    timeTable.getApptRange(listAppts, today, today);
        }
        catch(DateOutOfRangeException m){
		    assertEquals("Second date specified is not  before the first date specified.", m.getMessage());
        }
		assertNotEquals(null, timeTable.getApptRange(listAppts, today, tomorrow));
        assertEquals(6, listAppts.size());
		assertNotEquals(null, timeTable.deleteAppt(listAppts, appt2));
        assertNotEquals(null, timeTable.deleteAppt(listAppts, appt2));
		assertEquals(4, listAppts.size());
		assertEquals(false, listAppts.contains(appt2));
//		assertEquals(null, timeTable.deleteAppt(listAppts, appt0));
	}
    @Test
    public void test08() throws Throwable {
        Calendar rightnow = Calendar.getInstance();
        //current month/year/date is today
        int thisMonth = rightnow.get(Calendar.MONTH);
        int thisYear = rightnow.get(Calendar.YEAR);
        int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

        LinkedList<Appt> listAppts = new LinkedList<Appt>();
        GregorianCalendar aWhileAgo = new GregorianCalendar(thisYear, 1, 1);
        GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
        GregorianCalendar tomorrow = (GregorianCalendar) today.clone();
        tomorrow.add(Calendar.DAY_OF_MONTH, 1);

        TimeTable timeTable = new TimeTable();
        LinkedList<CalDay> calDays = new LinkedList<CalDay>();

                 /*Add an appointment to calendar*/
        int startHour = 20;
        int startMinute = 10;
        int startDay = thisDay;
        int startMonth = thisMonth;
        int startYear = thisYear;
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
        listAppts.add(appt0);
		/*Add an appointment to calendar*/
        startHour = 11;
        startMinute = 59;
        startDay = thisDay;
        startMonth = thisMonth;
        startYear = thisYear;
        title = "Party";
        description = "This is my party.";

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
        startDay = thisDay+1;
        startMonth = thisMonth;
        startYear = thisYear;
        title = "Party";
        description = "This is my party.";
        //Construct a new Appointment object with the initial data

        Appt appt2 = new Appt(startHour,
                startMinute,
                startDay,
                startMonth,
                startYear,
                title,
                description);
		/*Add an appointment to calendar*/
        listAppts.add(appt1);
        listAppts.add(appt2);
       // assertEquals(4, timeTable.getApptRange(listAppts, today, tomorrow).size());

                calDays = timeTable.getApptRange(listAppts, aWhileAgo, tomorrow);
        calDays.get(0).addAppt(appt1);
//        assertEquals(false, calDays.get(0).getAppts().contains(appt1));
    }
}