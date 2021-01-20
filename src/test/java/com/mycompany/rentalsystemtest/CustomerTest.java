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
public class CustomerTest {
    
    public CustomerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    Movie theManWhoKnewTooMuch;
    Customer c;
    @Before
    public void setUp() {
        theManWhoKnewTooMuch = new Movie("The Man Who Knew Too Much", Movie.REGULAR);
        c = new Customer("Aaron");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addMovieRental method, of class Customer.
     */
 
    public void testAddMovieRental() {
        assertTrue(c.addMovieRental(new MovieRental(new Movie("Mulan", Movie.CHILDRENS), 2)));
    }

    public void testAddVideoGameRental() {
        assertTrue(c.addVideoGameRental(new VideoGameRental("Gta V", 3, false)));
    }

    /**
     * Test of statement method, of class Customer.
     */
    @Test
    public void testStatement() {
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
    public void testGetName() {  
        String name = "John Doe"; 
        assertEquals(name, new Customer(name)._name);
    }
    
}
