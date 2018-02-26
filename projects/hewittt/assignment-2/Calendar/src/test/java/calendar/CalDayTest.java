package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
		 Calendar rightnow = Calendar.getInstance();
		 //current month/year/date is today
		 int thisMonth = rightnow.get(Calendar.MONTH);
		 int thisYear = rightnow.get(Calendar.YEAR);
		 int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		 GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
		 GregorianCalendar nextTwoMonths = (GregorianCalendar)today.clone();
		 tomorrow.add(Calendar.DAY_OF_MONTH,1);
		 nextTwoMonths.add(Calendar.DAY_OF_MONTH,2);
		 nextTwoMonths.add(Calendar.MONTH,2);

		 TimeTable timeTable=new TimeTable();
		 LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		 calDays = timeTable.getApptRange(listAppts, today, tomorrow);

		 assertEquals(true, calDays.get(0).getAppts().isEmpty());

                 /*Add an appointment to calendar*/
		 int startHour=12;
		 int startMinute=10;
		 int startDay=thisDay;
		 int startMonth=thisMonth+1;
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
		 calDays = timeTable.getApptRange(listAppts, today, tomorrow);


//		 assertEquals("\t --- 1/29/2018 --- \n" +
//				 " --- -------- Appointments ------------ --- \n", calDays.get(0).toString());

		 calDays = timeTable.getApptRange(listAppts, today, nextTwoMonths);
	//	 assertEquals("\t --- 2/30/2018 --- \n" +
	//			 " --- -------- Appointments ------------ --- \n\n", calDays.get(0).toString());

	 }
	 @Test
	  public void test02()  throws Throwable  {
		 Calendar rightnow = Calendar.getInstance();
		 //current month/year/date is today
		 int thisMonth = rightnow.get(Calendar.MONTH);
		 int thisYear = rightnow.get(Calendar.YEAR);
		 int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		 GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
		 GregorianCalendar nextThreeMonths = (GregorianCalendar)today.clone();
		 tomorrow.add(Calendar.DAY_OF_MONTH,1);
		 nextThreeMonths.add(Calendar.MONTH,3);

		 TimeTable timeTable=new TimeTable();
		 LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		 calDays = timeTable.getApptRange(listAppts, today, tomorrow);

		 assertEquals(true, calDays.get(0).getAppts().isEmpty());

                 /*Add an appointment to calendar*/
		 int startHour=12;
		 int startMinute=10;
		 int startDay=thisDay;
		 int startMonth=thisMonth+1;
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

         startHour=13;
         startMinute=10;
         startDay=thisDay;
         startMonth=thisMonth+1;
         startYear=thisYear;
         title="Another party";
         description="This is another party.";
         //Construct a new Appointment object with the initial data
         Appt appt2 = new Appt(startHour,
                 startMinute ,
                 startDay ,
                 startMonth ,
                 startYear ,
                 title,
                 description);

         listAppts.add(appt2);

         startHour=3;
         startMinute=10;
         startDay=thisDay;
         startMonth=thisMonth+1;
         startYear=thisYear;
         title="Another another party";
         description="This is another another party.";
         //Construct a new Appointment object with the initial data
         Appt appt3 = new Appt(startHour,
                 startMinute ,
                 startDay ,
                 startMonth ,
                 startYear ,
                 title,
                 description);

         listAppts.add(appt3);

		 calDays = timeTable.getApptRange(listAppts, today, nextThreeMonths);

		 assertEquals(0, calDays.get(0).getSizeAppts());
         for (int i = 0; i < calDays.size(); i++) {
             if (calDays.get(i).getSizeAppts() == 3) {
/*                 assertEquals("\t --- 3/29/2018 --- \n" +
                         " --- -------- Appointments ------------ --- \n" +
                         "\n   2/28/2018 at 3:10 am , Another another party, This is another another party." +
                         "\n   2/28/2018 at 12:10 pm ,Party, This is my party." +
                         "\n   2/28/2018 at 1:10 pm ,Another party, This is another party.", calDays.get(i).toString());
  */           }
         }
	 }
	@Test
	public void test03()  throws Throwable  {
		Calendar rightnow = Calendar.getInstance();
		//current month/year/date is today
		int thisMonth = rightnow.get(Calendar.MONTH);
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
		GregorianCalendar nextTwoMonths = (GregorianCalendar)today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH,1);
		nextTwoMonths.add(Calendar.DAY_OF_MONTH,2);
		nextTwoMonths.add(Calendar.MONTH,2);

		TimeTable timeTable=new TimeTable();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		calDays = timeTable.getApptRange(listAppts, today, tomorrow);

		assertEquals(true, calDays.get(0).getAppts().isEmpty());

                 /*Add an appointment to calendar*/
		int startHour=27;
		int startMinute=10;
		int startDay=thisDay;
		int startMonth=thisMonth+1;
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

		calDays = timeTable.getApptRange(listAppts, today, nextTwoMonths);
		assertEquals(false, appt.getValid());

	}
    @Test
    public void test04()  throws Throwable  {
        Calendar rightnow = Calendar.getInstance();
        //current month/year/date is today
        int thisMonth = rightnow.get(Calendar.MONTH);
        int thisYear = rightnow.get(Calendar.YEAR);
        int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

        LinkedList<Appt> listAppts = new LinkedList<Appt>();
        GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
        GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
        GregorianCalendar nextTwoMonths = (GregorianCalendar)today.clone();
        tomorrow.add(Calendar.DAY_OF_MONTH,1);
        nextTwoMonths.add(Calendar.DAY_OF_MONTH,2);
        nextTwoMonths.add(Calendar.MONTH,2);

        TimeTable timeTable=new TimeTable();
        LinkedList<CalDay> calDays = new LinkedList<CalDay>();
        calDays = timeTable.getApptRange(listAppts, today, tomorrow);

        assertEquals(true, calDays.get(0).getAppts().isEmpty());

                 /*Add an appointment to calendar*/
        int startHour=27;
        int startMinute=10;
        int startDay=thisDay;
        int startMonth=thisMonth+1;
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

        calDays = timeTable.getApptRange(listAppts, today, nextTwoMonths);
        assertEquals(false, appt.getValid());

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
	 public void test06() throws Throwable{
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

		 assertEquals(false, appt.getValid());
		 listAppts.add(appt);
		 calDays.get(0).addAppt(appt);
		 calDays.get(0).toString();
		 calDays.get(0).iterator();
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

        assertEquals(false, appt.getValid());
        listAppts.add(appt);
        calDays.get(0).iterator();
//        assertEquals(null, calDays.get(0).toString());
	 }
      //add more unit tests as you needed
}
