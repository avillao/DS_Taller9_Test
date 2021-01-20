/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rentalsystemtest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author le
 */
public class MovieRentalTest {
    
    public MovieRentalTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @After
    public void tearDown() {
    }
    
    Movie theManWhoKnewTooMuch, mulan, slumdogMillionaire;
    Customer c;
    @Before
    public void setUp() {
        theManWhoKnewTooMuch = new Movie("The Man Who Knew Too Much", Movie.REGULAR);
        mulan = new Movie("Mulan", Movie.CHILDRENS);
        slumdogMillionaire = new Movie("Slumdog Millionaire", Movie.NEW_RELEASE);
        
    }
    
    /**
     * Test of getDaysRented method, of class MovieRental.
     */
    @Test
    public void testGetDaysRented() {
        assertEquals(2, new MovieRental(theManWhoKnewTooMuch, 2).getDaysRented());
    }

    /**
     * Test of getMovie method, of class MovieRental.
     */
    @Test
    public void testGetMovie() {
        assertEquals(theManWhoKnewTooMuch, new MovieRental(theManWhoKnewTooMuch, 2).getMovie());
    }
    
    @Test
    public void testStatementRegularMovieOnly() {
        // regular movies cost $2.00 for the first 2 days, and $1.50/day thereafter
        // a rental earns 1 frequent-renter point no matter how many days
        Customer johnDoe = new Customer("John Doe");
        johnDoe.addMovieRental(new MovieRental(theManWhoKnewTooMuch, 1));
        assertEquals("Rental Record for John Doe\n" +
                     "\tThe Man Who Knew Too Much\t2.0\n" +
                     "Amount owed is 2.0\n" +
                     "You earned 1 frequent renter points", johnDoe.statement());
        johnDoe.addMovieRental(new MovieRental(theManWhoKnewTooMuch, 3));
        assertEquals("Rental Record for John Doe\n" +
                     "\tThe Man Who Knew Too Much\t2.0\n" +
                     "\tThe Man Who Knew Too Much\t3.5\n" +
                     "Amount owed is 5.5\n" +
                     "You earned 2 frequent renter points", johnDoe.statement());
        johnDoe.addMovieRental(new MovieRental(theManWhoKnewTooMuch, 5));
        assertEquals("Rental Record for John Doe\n" +
                     "\tThe Man Who Knew Too Much\t2.0\n" +
                     "\tThe Man Who Knew Too Much\t3.5\n" +
                     "\tThe Man Who Knew Too Much\t6.5\n" +
                     "Amount owed is 12.0\n" +
                     "You earned 3 frequent renter points", johnDoe.statement());
        
    }

    @Test
    public void testStatementChildrensMovieOnly() {
        // childrens' movies cost $1.50 for the first 3 days, and $1.25/day thereafter
        // a rental earns 1 frequent-renter point no matter how many days
        Customer johnDoeJr = new Customer("Johnny Doe, Jr.");
        johnDoeJr.addMovieRental(new MovieRental(mulan, 1));
        assertEquals("Rental Record for Johnny Doe, Jr.\n" +
                     "\tMulan\t1.5\n" +
                     "Amount owed is 1.5\n" +
                     "You earned 1 frequent renter points", johnDoeJr.statement());
        johnDoeJr.addMovieRental(new MovieRental(mulan, 3));
        assertEquals("Rental Record for Johnny Doe, Jr.\n" +
                     "\tMulan\t1.5\n" +
                     "\tMulan\t1.5\n" +
                     "Amount owed is 3.0\n" +
                     "You earned 2 frequent renter points", johnDoeJr.statement());
        johnDoeJr.addMovieRental(new MovieRental(mulan, 5));
        assertEquals("Rental Record for Johnny Doe, Jr.\n" +
                     "\tMulan\t1.5\n" +
                     "\tMulan\t1.5\n" +
                     "\tMulan\t4.0\n" +
                     "Amount owed is 7.0\n" +
                     "You earned 3 frequent renter points", johnDoeJr.statement());
    }

    @Test
    public void testStatementNewReleaseOnly() {
        // new releases cost $3.00/day
        // a rental earns 1 frequent-renter point 1 day; 2 points for 2 or more days
        Customer janeDoe = new Customer("Jane Doe");
        janeDoe.addMovieRental(new MovieRental(slumdogMillionaire, 1));
        assertEquals("Rental Record for Jane Doe\n" +
                     "\tSlumdog Millionaire\t3.0\n" +
                     "Amount owed is 3.0\n" +
                     "You earned 1 frequent renter points", janeDoe.statement());
        janeDoe.addMovieRental(new MovieRental(slumdogMillionaire, 3));
        assertEquals("Rental Record for Jane Doe\n" +
                     "\tSlumdog Millionaire\t3.0\n" +
                     "\tSlumdog Millionaire\t9.0\n" +
                     "Amount owed is 12.0\n" +
                     "You earned 3 frequent renter points", janeDoe.statement());
        janeDoe.addMovieRental(new MovieRental(slumdogMillionaire, 5));
        assertEquals("Rental Record for Jane Doe\n" +
                     "\tSlumdog Millionaire\t3.0\n" +
                     "\tSlumdog Millionaire\t9.0\n" +
                     "\tSlumdog Millionaire\t15.0\n" +
                     "Amount owed is 27.0\n" +
                     "You earned 5 frequent renter points", janeDoe.statement());
    }
    
}
