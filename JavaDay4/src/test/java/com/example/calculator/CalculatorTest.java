package com.example.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.example.testing.Calculator;

public class CalculatorTest {
	
	static Calculator calc;
	
	@BeforeClass
	public static void setupBeforeClass() throws Exception{
		System.out.println("This runs before any tests");
		calc = new Calculator();
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		System.out.println("This runs after the entire class is finished");
	}
	
	@Before
	public void setup() throws Exception{
		System.out.println("This runs before every test");
	}
	
	@After
	public void tearDown() throws Exception{
		System.out.println("This runs after every test");
	}
	
	@Test
	public void positiveAdditionTest() {
		//assertEquals(String message, expected, actual)
		assertEquals("Testing 2+2=4", 4, calc.add(2, 2));
	}
	
	@Test
	public void negativeAdditionTest() {
		assertNotEquals("Testing 2+3!=4", 4, calc.add(2, 3));
	}
	
	@Ignore //If we want to ignore a test, we can use @Ignore
	//@Test
	public void subTest() {
		assertEquals("Testing 3-1=2", 2, calc.sub(3, 1));
	}
	
	@Test(expected = ArithmeticException.class)
	public void testDivideByZero() {
		calc.divide(2, 0);
	}
	
}
