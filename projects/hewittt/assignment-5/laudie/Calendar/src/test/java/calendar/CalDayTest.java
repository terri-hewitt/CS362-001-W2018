package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class CalDayTest {

	@Test
	public void test01() throws Throwable {
		Calendar rightnow = Calendar.getInstance();
		//current month/year/date is today
		int thisMonth = rightnow.get(Calendar.MONTH);
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar) today.clone();
		GregorianCalendar nextTwoMonths = (GregorianCalendar) today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH, 1);
		nextTwoMonths.add(Calendar.DAY_OF_MONTH, 2);
		nextTwoMonths.add(Calendar.MONTH, 2);

		TimeTable timeTable = new TimeTable();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = timeTable.getApptRange(listAppts, today, tomorrow);

		assertEquals(true, calDays.get(0).getAppts().isEmpty());

                 /*Add an appointment to calendar*/
		int startHour = 12;
		int startMinute = 10;
		int startDay = thisDay;
		int startMonth = thisMonth + 1;
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
		calDays = timeTable.getApptRange(listAppts, today, tomorrow);


//		 assertEquals("\t --- 1/29/2018 --- \n" +
//				 " --- -------- Appointments ------------ --- \n", calDays.get(0).toString());

		calDays = timeTable.getApptRange(listAppts, today, nextTwoMonths);
//		 assertEquals("\t --- 2/30/2018 --- \n" +
//				 " --- -------- Appointments ------------ --- \n\n", calDays.get(0).toString());

	}

	@Test
	public void test02() throws Throwable {
		Calendar rightnow = Calendar.getInstance();
		//current month/year/date is today
		int thisMonth = rightnow.get(Calendar.MONTH);
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar) today.clone();
		GregorianCalendar nextThreeMonths = (GregorianCalendar) today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH, 1);
		nextThreeMonths.add(Calendar.MONTH, 3);

		TimeTable timeTable = new TimeTable();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = timeTable.getApptRange(listAppts, today, tomorrow);

		assertEquals(true, calDays.get(0).getAppts().isEmpty());

                 /*Add an appointment to calendar*/
		int startHour = 12;
		int startMinute = 10;
		int startDay = thisDay;
		int startMonth = thisMonth + 1;
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

		startHour = 13;
		startMinute = 10;
		startDay = thisDay;
		startMonth = thisMonth + 1;
		startYear = thisYear;
		title = "Another party";
		description = "This is another party.";
		//Construct a new Appointment object with the initial data
		Appt appt2 = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);

		listAppts.add(appt2);

		startHour = 3;
		startMinute = 10;
		startDay = thisDay;
		startMonth = thisMonth + 1;
		startYear = thisYear;
		title = "Another another party";
		description = "This is another another party.";
		//Construct a new Appointment object with the initial data
		Appt appt3 = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);

		listAppts.add(appt3);
        //listAppts.add(appt2;)

		calDays = timeTable.getApptRange(listAppts, today, nextThreeMonths);

		assertEquals(0, calDays.get(0).getSizeAppts());
		for (int i = 0; i < calDays.size(); i++) {
			if (calDays.get(i).getSizeAppts() == 3) {
				assertEquals(thisDay, calDays.get(i).getDay());
				assertEquals(thisMonth + 3, calDays.get(i).getMonth());
				assertEquals(thisYear, calDays.get(i).getYear());
                assertEquals(0, calDays.get(i).getAppts().indexOf(appt3));
                assertEquals(2, calDays.get(i).getAppts().indexOf(appt2));
                assertEquals(1, calDays.get(i).getAppts().indexOf(appt));
				/*
assertEquals("\t --- 3/29/2018 --- \n" +
                         " --- -------- Appointments ------------ --- \n" +
                         "\n   2/10/2018 at 3:10 am , Another another party, This is another another party." +
                         "\n   2/10/2018 at 12:10 pm ,Party, This is my party." +
                         "\n   2/10/2018 at 1:10 pm ,Another party, This is another party.", calDays.get(i).toString());
  */
			}
		}
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
		GregorianCalendar nextTwoMonths = (GregorianCalendar) today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH, 1);
		nextTwoMonths.add(Calendar.DAY_OF_MONTH, 2);
		nextTwoMonths.add(Calendar.MONTH, 2);

		TimeTable timeTable = new TimeTable();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = timeTable.getApptRange(listAppts, today, tomorrow);

		assertEquals(true, calDays.get(0).getAppts().isEmpty());

                 /*Add an appointment to calendar*/
		int startHour = 27;
		int startMinute = 10;
		int startDay = thisDay;
		int startMonth = thisMonth + 1;
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

	//	assertEquals(false, appt.getValid());
		calDays = timeTable.getApptRange(listAppts, today, nextTwoMonths);
		calDays.getFirst().addAppt(appt);
		appt.setStartHour(1);
		calDays.getFirst().addAppt(appt);

		assertEquals(1, calDays.getFirst().getAppts().getFirst().getStartHour());
		assertEquals(true, appt.getValid());

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
		GregorianCalendar nextTwoMonths = (GregorianCalendar) today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH, 1);
		nextTwoMonths.add(Calendar.DAY_OF_MONTH, 2);
		nextTwoMonths.add(Calendar.MONTH, 2);

		TimeTable timeTable = new TimeTable();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = timeTable.getApptRange(listAppts, today, tomorrow);

		assertEquals(true, calDays.get(0).getAppts().isEmpty());

                 /*Add an appointment to calendar*/
		int startHour = 27;
		int startMinute = 10;
		int startDay = thisDay;
		int startMonth = thisMonth + 1;
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

		calDays = timeTable.getApptRange(listAppts, today, nextTwoMonths);
//		assertEquals(false, appt.getValid());

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
		GregorianCalendar nextTwoMonths = (GregorianCalendar) today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH, 1);
		nextTwoMonths.add(Calendar.DAY_OF_MONTH, 2);
		nextTwoMonths.add(Calendar.MONTH, 2);

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
		Appt appt = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);

		listAppts.add(appt);
		assertNotEquals(null, calDays.iterator());
		assertEquals(true, appt.getValid());

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
		GregorianCalendar nextTwoMonths = (GregorianCalendar) today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH, 1);
		nextTwoMonths.add(Calendar.DAY_OF_MONTH, 2);
		nextTwoMonths.add(Calendar.MONTH, 2);

		TimeTable timeTable = new TimeTable();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		//assertEquals(null, calDays.get(0).toString());

		calDays = timeTable.getApptRange(listAppts, today, tomorrow);

		assertEquals(true, calDays.get(0).getAppts().isEmpty());

                 /*Add an appointment to calendar*/
		int startHour = -200;
		int startMinute = 10;
		int startDay = 28;
		int startMonth = 2;
		int startYear = 2018;
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

//		assertEquals(false, appt.getValid());
//		assertEquals(null, appt.toString());
		listAppts.add(appt);
		assertEquals(true, listAppts.contains(appt));
		calDays.get(0).addAppt(appt);
//		assertEquals(false, calDays.get(0).getAppts().contains(appt));
		calDays.get(0).toString();

	/*	CalDay badDay;
		badDay.setDay(thisDay);
		badDay.setMonth(thisMonth);
		assertEquals(null, badDay.toString());
	*/	calDays.get(0).iterator();
		assertNotEquals(null, calDays.get(0).iterator());
	}

	@Test
	public void test07() throws Throwable {
		Calendar rightnow = Calendar.getInstance();
		//current month/year/date is today
		int thisMonth = rightnow.get(Calendar.MONTH);
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar) today.clone();
		GregorianCalendar nextTwoMonths = (GregorianCalendar) today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH, 1);
		nextTwoMonths.add(Calendar.DAY_OF_MONTH, 2);
		nextTwoMonths.add(Calendar.MONTH, 2);

		TimeTable timeTable = new TimeTable();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = timeTable.getApptRange(listAppts, today, tomorrow);

		assertEquals(true, calDays.get(0).getAppts().isEmpty());
                 /*Add an appointment to calendar*/
		int startHour = -200;
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

//		assertEquals(false, appt.getValid());
		//timeTable.getApptRange(listAppts, today, tomorrow).size();
		assertEquals(1, timeTable.getApptRange(listAppts, today, tomorrow).size());

		try{
		    timeTable.getApptRange(listAppts, tomorrow, today);
		    fail("Expected date out of range exception to be thrown");
        }catch (DateOutOfRangeException m){

		    assertEquals(m.getMessage(), "Second date specified is not  before the first date specified.");
        }

        assertFalse(calDays.get(0).getAppts().contains(appt));
		listAppts.add(appt);
		appt.setStartHour(10);
		calDays.get(0).addAppt(appt);
        listAppts.add(appt);
		calDays.get(0).iterator();
		for (int i = 0; i < calDays.size(); i++) {
			if (calDays.get(i).isValid() == false) {
                assertEquals(null, calDays.get(i).iterator());
                //assertEquals(null);
			}

		}
		appt.setStartHour(1);
		assertEquals(1, appt.getStartHour());
		calDays.get(0).addAppt(appt);
		assertTrue(calDays.get(0).getAppts().contains(appt));
//        assertEquals(null, calDays.get(0).toString());
	}

	@Test
	public void test08() throws Throwable {
		Calendar rightnow = Calendar.getInstance();
		//current month/year/date is today
		int thisMonth = rightnow.get(Calendar.MONTH);
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar) today.clone();
		GregorianCalendar nextTwoMonths = (GregorianCalendar) today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH, 1);
		nextTwoMonths.add(Calendar.DAY_OF_MONTH, 2);
		nextTwoMonths.add(Calendar.MONTH, 2);

		TimeTable timeTable = new TimeTable();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = timeTable.getApptRange(listAppts, today, tomorrow);

		assertEquals(true, calDays.get(0).getAppts().isEmpty());
                 /*Add an appointment to calendar*/
		int startHour = 22;
		int startMinute = 10;
		int startDay = 30;
		int startMonth = 1;
		int startYear = 2018;
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

		int r[] = {};
		assertEquals(false, appt.getValid());
		listAppts.add(appt);
		assertEquals(null, appt.toString());

		appt.setStartHour(23);
//		assertEquals(true, appt.getValid());
		listAppts.add(appt);
		calDays.get(0).addAppt(appt);
		appt.setRecurrence(r, Appt.RECUR_BY_WEEKLY, 0, Appt.RECUR_NUMBER_FOREVER);
		assertEquals(false, timeTable.getApptRange(listAppts, today, nextTwoMonths).contains(appt));//size());
      //  assertEquals();
		appt.setRecurrence(r, Appt.RECUR_BY_MONTHLY, 0, Appt.RECUR_NUMBER_NEVER);
        assertEquals(63, timeTable.getApptRange(listAppts, today, nextTwoMonths).size());

        //int sizeAppts = 0;
        //for(int i=0; i < 30; i++){
            try{calDays.get(1).getSizeAppts();}
            catch(IndexOutOfBoundsException m){
                assertEquals("Index: 1, Size: 1", m.getMessage());
            }
        //}
//        assertEquals(1, calDays.get(0).getAppts().size());
        appt.setRecurrence(r, Appt.RECUR_BY_YEARLY, 0, Appt.RECUR_NUMBER_FOREVER);
        assertEquals(63, timeTable.getApptRange(listAppts, today, nextTwoMonths).size());
		assertEquals(r, appt.getRecurDays());
		//add more unit tests as you needed
	}
}