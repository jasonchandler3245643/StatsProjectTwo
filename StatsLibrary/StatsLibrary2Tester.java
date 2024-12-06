import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StatsLibrary2Tester {

	private StatsLibrary tester = new StatsLibrary();

	@Test
	void testCombo() {
		
		BigInteger intBig = BigInteger.valueOf(386206920);
		
		 assertEquals(tester.calculateCombination(60, 7), intBig);
		
	}
	
	@Test
	void testPermutation() {
		BigInteger intBig = BigInteger.valueOf(720);
		
		assertEquals(tester.calculatePermutation(10, 3), intBig);
		
	}
	
	@Test
	void testBinomialDistribution() {
		
		BigDecimal binomialDist = tester.binomialDistribution(.5, .5, 5, 3);
		int comparison = binomialDist.compareTo(new BigDecimal(0.31250));
		
		assertEquals(0, comparison);
		
	}
	
	@Test
	void testExpectedBinomialDistribution() {
		
		
		assertEquals(tester.expectedBinomialDistribution(.5, 5), 2.5);
		
	}
	
	@Test
	void testVarienceBinomialDistribution() {
		
		
		assertEquals(tester.varianceBinomialDistribution(.5, .5, 5), 1.25);
		
	}
	
	
	@Test
	void testGeometricDistribution() {
		
		assertEquals(tester.geometricDistribution(.5, .5, 3), .125);
		
	}
	
	@Test
	void testExpectedGeometricDistribution() {
		
		
		assertEquals(tester.expectedGeometricDistribution(.5), 2.0);
		
	}
	
	@Test
	void testVarienceGeometricDistribution() {
		
		
		assertEquals(tester.varianceGeometricDistribution(.5), 2.0);
		
	}

}
