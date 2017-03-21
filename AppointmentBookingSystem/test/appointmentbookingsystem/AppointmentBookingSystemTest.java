/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentbookingsystem;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apex
 */
public class AppointmentBookingSystemTest {
    
    public AppointmentBookingSystemTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of AddWorkingTime method, of class AppointmentBookingSystem.
     */
    @Test
    public void testAddWorkingTime() {
        System.out.println("AddWorkingTime");
        AppointmentBookingSystem.AddWorkingTime();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ShowSummaries method, of class AppointmentBookingSystem.
     */
    @Test
    public void testShowSummaries() {
        System.out.println("ShowSummaries");
        AppointmentBookingSystem.ShowSummaries();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showWorkingTimeTable method, of class AppointmentBookingSystem.
     */
    @Test
    public void testShowWorkingTimeTable() {
        System.out.println("showWorkingTimeTable");
        AppointmentBookingSystem.showWorkingTimeTable();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showBookingTimeTable method, of class AppointmentBookingSystem.
     */
    @Test
    public void testShowBookingTimeTable() {
        System.out.println("showBookingTimeTable");
        AppointmentBookingSystem.showBookingTimeTable();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BookSlot method, of class AppointmentBookingSystem.
     */
    @Test
    public void testBookSlot() {
        System.out.println("BookSlot");
        ArrayList<String> data = null;
        int slotNo = 0;
        AppointmentBookingSystem.BookSlot(data, slotNo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BookAppointment method, of class AppointmentBookingSystem.
     */
    @Test
    public void testBookAppointment() {
        System.out.println("BookAppointment");
        AppointmentBookingSystem.BookAppointment();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class AppointmentBookingSystem.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        AppointmentBookingSystem.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
