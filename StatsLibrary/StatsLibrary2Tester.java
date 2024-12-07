import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StatsLibrary2Tester {

	private StatsLibrary tester = new StatsLibrary();

	DecimalFormat df = new DecimalFormat("0.####");
	
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

	@Test
	void testHypergeometricDistribution() {
		
		assertEquals(df.format(tester.hypergeometricDistribution(10, 5, 5, 2)), df.format(.3968));
		
	}
	
	@Test
	void testExpectedHypergeometric() {
		
		assertEquals(tester.hypergeometricExpected(10, 5, 5), 2.5);
		
	}
	
	@Test
	void testVarienceHypergeometric() {
		
		assertEquals(df.format(tester.hypergeometricVariance(10, 5, 5)), df.format(.6944));
		
	}
	
	@Test
	void testNegativeBinomial() {
		
		assertEquals(df.format(tester.negativeBinomial(5, 3, .6)), df.format(.2074));
		
	}
	
	@Test
	void testExpectedNegativeBinomial() {
		
		assertEquals(df.format(tester.negativeBionmialExpected(3, .6)), df.format(5));
		
	}
	
	@Test
	void testVarienceNegativeBinomial() {
		
		assertEquals(df.format(tester.negativeBinomialVariance(3, .6)), df.format(3.3333));
		
	}
	
	@Test
	void testPoisson() {
		
		assertEquals(df.format(tester.poissonDistribution(4, 10)), df.format(.0053));
		
	}
	
	@Test
	void testExpectedPoisson() {
		
		assertEquals(df.format(tester.poissonExpected(4)), df.format(4));
		
	}
	
	@Test
	void testVariancePoisson() {
		
		assertEquals(df.format(tester.poissonVariance(4)), df.format(4));
		
	}
	
	@Test
	void testTchebysheffRante() {
		
		assertEquals(df.format(tester.getTchebysheffRate(4)), df.format(.9375));
		
	}
	
	@Test
	void testTchebysheffWithin() {
	
		assertEquals(df.format(tester.getTchebysheffWithin(4, 8, 6)), df.format(2));
		
	}
	
	@Test
	void testTchebysheffWithinInvalid() {
		
		assertEquals(df.format(tester.getTchebysheffWithin(3, 8, 6)), df.format(0));
		
	}
	
	@Test
	void testTchebysheffTotal() {
		
		assertEquals(df.format(tester.getTchebysheffAllParams(4, 8, 6, 1)), df.format(.75));
		
	}
	
	@Test
	void testUniformDistributionSinglePoint() {
		
		assertEquals(df.format(tester.uniformDistributionSinglePoint(29, 30)), df.format(.9667));
		
	}
	
	@Test
	void testUniformDistributionTwoPoints() {
		
		assertEquals(df.format(tester.uniformDistributionSinglePoint(30, 25, 30)), df.format(.1667));
		
	}
	
	@Test
	void testNormalProbabilityDistribution() {
		
		assertEquals(df.format(tester.normalProbabilityDistribution(2, 3, 2)), df.format(.176));
		
	}
	
	@Test
	void testOneExponentialCDF() {
		
		assertEquals(df.format(tester.exponentialSingleCDF(9, 3.6)), df.format(.0821));
		
	}
	
	@Test
	void testCommonMultivariate() {
		
		assertEquals(df.format(tester.commonMultivariateProblem(3, 2, 1, 1, 6, 2)), df.format(.4));
		
	}
}
