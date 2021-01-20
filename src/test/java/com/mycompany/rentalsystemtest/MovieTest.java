/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rentalsystemtest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author USER
 */
public class MovieTest {
    
    public MovieTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getPriceCode method, of class Movie.
     */
    @Test
    public void testGetPriceCode() {
        System.out.println("getPriceCode");
        Movie instance = new Movie("Over the moon", Movie.CHILDRENS);
        int expResult = Movie.CHILDRENS;
        int result = instance.getPriceCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPriceCode method, of class Movie.
     */
    @Test
    public void testSetPriceCode() {
        System.out.println("setPriceCode");
        int arg = Movie.CHILDRENS;
        Movie instance = new Movie("Over the moon", Movie.CHILDRENS);
        instance.setPriceCode(arg);
        assertEquals(arg, instance.getPriceCode());
    }
    
    Movie theManWhoKnewTooMuch;
    @Test
    public void testGetTitle() {
        Movie theManWhoKnewTooMuch = new Movie("The Man Who Knew Too Much", Movie.REGULAR);
        assertEquals("The Man Who Knew Too Much", theManWhoKnewTooMuch._title);
    }
    
}
