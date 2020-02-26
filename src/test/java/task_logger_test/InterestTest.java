package task_logger_test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import task_logger.ILogger;
import task_logger.InterestCalculator;
import task_logger.NegativeValuesException;

public class InterestTest {

	@Test
	public void testCompoundInterest() throws NegativeValuesException {
		assertEquals(10.0,InterestCalculator.calculateCompoundInterest(100, 1, 10), 0.001);
	}
	
	@Test
	public void testSimpleInterest() throws NegativeValuesException {
		assertEquals(10.0,InterestCalculator.calculateSimpleInterest(100, 1, 10), 0.001);
	}

	@Test
	public void testSimpleInterestRate(){	
		try {
			InterestCalculator.calculateSimpleInterest(100, 1, -10);			
		}catch(NegativeValuesException ex) {
			ILogger.LOGGER.debug(ex.getMessage());
			assertEquals("Rate", ex.getMessage());
		}
	}
	
	@Test
	public void testSimpleInterestTime(){	
		try {
			InterestCalculator.calculateSimpleInterest(100, -1, 10);			
		}catch(NegativeValuesException ex) {
			ILogger.LOGGER.debug(ex.getMessage());
			assertEquals("Time", ex.getMessage());
		}
	}
	
	@Test
	public void testSimpleInterestPrincipal() {	
		try {
			InterestCalculator.calculateSimpleInterest(-100, 1, 10);			
		}catch(NegativeValuesException ex) {
			ILogger.LOGGER.debug(ex.getMessage());
			assertEquals("Principal", ex.getMessage());
		}
	}
	
	@Test
	public void testCompoundInterestRate() throws Exception{	
		try {
			InterestCalculator.calculateCompoundInterest(100, 1, -10);			
		}catch(NegativeValuesException ex) {
			ILogger.LOGGER.debug(ex.getMessage());
			assertEquals("Compound Rate", ex.getMessage());
		}
	}
	
	@Test
	public void testCompoundInterestTime() throws Exception{	
		try {
			InterestCalculator.calculateCompoundInterest(100, -1, 10);			
		}catch(NegativeValuesException ex) {
			ILogger.LOGGER.debug(ex.getMessage());
			assertEquals("Compound Time", ex.getMessage());
		}
	}
	
	@Test
	public void testCompoundInterestPrincipal() throws Exception{	
		try {
			InterestCalculator.calculateCompoundInterest(-100, 1, 10);			
		}catch(NegativeValuesException ex) {
			ILogger.LOGGER.debug(ex.getMessage());
			assertEquals("Compound Principal", ex.getMessage());
		}
	}
}
