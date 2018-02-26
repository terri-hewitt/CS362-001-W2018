package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
//		 assertEquals("This is my birthday party.", appt.getDescription());
	 }

	 @Test
	  public void test02()  throws Throwable  {
		 int startHour = 21;
		 int startMinute = 30;
		 int startDay = 15;
		 int startMonth = 01;
		 int startYear = 2018;
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
		 // assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 //      assertEquals("This is my birthday party.", appt.getDescription());

		 startHour = 22;
		 startMinute = 30;
		 startDay = 15;
		 startMonth = 01;
		 startYear = 2018;
		 title = "Birthday Party";
		 description = "This is my birthday party!";
		 //Construct a new Appointment object with the initial data
		 Appt appt2 = new Appt(startHour,
				 startMinute,
				 startDay,
				 startMonth,
				 startYear,
				 title,
				 description);
		 // assertions
		 assertTrue(appt2.getValid());
		 assertEquals(22, appt2.getStartHour());
		 assertEquals(30, appt2.getStartMinute());
		 assertEquals(15, appt2.getStartDay());
		 assertEquals(01, appt2.getStartMonth());
		 assertEquals(2018, appt2.getStartYear());
		 assertEquals(1, appt2.compareTo(appt));
		 assertEquals("Birthday Party", appt2.getTitle());
//              assertEquals("\t01/15/2018 at 10:30pm, Birthday Party, This is my birthday party.\n", appt.toString());
//              assertEquals("This is my birthday party.", appt2.getDescription());

	 }

	 @Test
     public void test03() throws Throwable {
         int startHour = 25;
         int startMinute = 30;
         int startDay = 24;
         int startMonth = 01;
         int startYear = 2018;
         String title = "Start Hour error";
         String description = "start hour.";
         //Construct a new Appointment object with the initial data
         Appt appt = new Appt(startHour,
                 startMinute,
                 startDay,
                 startMonth,
                 startYear,
                 title,
                 description);
         // assertions
         assertFalse(appt.getValid());

     }

    @Test
    public void test04() throws Throwable {
        int startHour = 1;
        int startMinute = -1;
        int startDay = 24;
        int startMonth = 01;
        int startYear = 2018;
        String title = "Start minute error";
        String description = "start minute.";
        //Construct a new Appointment object with the initial data
        Appt appt = new Appt(startHour,
                startMinute,
                startDay,
                startMonth,
                startYear,
                title,
                description);
        // assertions
        assertEquals(false, appt.getValid());

    }

    @Test
    public void test05() throws Throwable {
        int startHour = 1;
        int startMinute = 59;
        int startDay = 31;
        int startMonth = 02;
        int startYear = 2018;
        String title = "Start day error";
        String description = "start day.";
        //Construct a new Appointment object with the initial data
        Appt appt = new Appt(startHour,
                startMinute,
                startDay,
                startMonth,
                startYear,
                title,
                description);

        int[] recurDaysArr={2,3,4};
        appt.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
        appt.setTitle("New title");
        appt.setStartMinute(13);
        appt.setStartDay(32);
        appt.setStartHour(3);
        appt.setStartMonth(12);
        appt.setStartYear(2020);
        // assertions
        assertEquals("New title", appt.getTitle());
        //appt.setDescription("Description");
        //assertEquals("Description", appt.getDescription());
        assertEquals(13, appt.getStartMinute());
        assertEquals(32, appt.getStartDay());
        assertEquals(3, appt.getStartHour());
        assertEquals(12, appt.getStartMonth());
        assertEquals(2, appt.getRecurIncrement());
        assertEquals(2020, appt.getStartYear());
//              assertEquals(false, appt.getValid());
    }

    @Test
	public void test06() throws Throwable {
		int startHour = 2;
		int startMinute = 300;
		int startDay = 24;
		int startMonth = 01;
		int startYear = 2018;
		String title = "Start minute error";
		String description = "start minute.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);
		// assertions
		assertEquals(false, appt.getValid());
	}

	@Test
	public void test07() throws Throwable {
		int startHour = 2;
		int startMinute = 30;
		int startDay = 0;
		int startMonth = 2;
		int startYear = 2018;
		String title = "Start day error";
		String description = "start day.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);
		// assertions
//		assertEquals(false, appt.getValid());
	}

	@Test
	public void test08() throws Throwable {
		int startHour = 2;
		int startMinute = 30;
		int startDay = 24;
		int startMonth = 11;
		//int startMonth = 14;
		int startYear = 2018;
		String title = "Start month error";
		String description = "start month.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);
		// assertions
//		assertEquals(false, appt.getValid());
	}
	@Test
	public void test09() throws Throwable {
		int startHour = -2;
		int startMinute = 30;
		int startDay = 24;
		int startMonth = 01;
		int startYear = 2018;
		String title = null;
		String description = null;
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);
		// assertions
		appt.setRecurrence(null, 1, 1, 1);
		assertEquals(1, appt.getRecurBy());
		assertEquals(false, appt.getValid());
		assertEquals(null, appt.toString());
	}
	@Test
	public void test10() throws Throwable {
		int startHour = 2;
		int startMinute = 30;
		int startDay = 1;
		int startMonth = 10;
	//	int startMonth = 30;
		int startYear = 2018;
		String title = "Start month error";
		String description = "start month.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);
		// assertions
//		assertEquals(false, appt.getValid());
//		appt.setStartMonth(20);
//		assertEquals(false, appt.getValid());
	}

}
