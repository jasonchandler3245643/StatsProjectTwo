import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Relevant formulas to the second half of the semester
 * 
 * 
 * @author Jason Chandler
 *
 */
public class StatsLibrary {

	
	/**
     * Recursive BigInteger factorial method for
     * solving combinations and permutations.
     * 
     * @param num Each subsequent number being multiplied.
     * @return The BigInteger version of a factorial
     */
    private BigInteger factorial(int num) {

        // base
        if (num == 0) 
            return BigInteger.ONE;
            
        else
            return BigInteger.valueOf(num).multiply(factorial(num-1));
        }

    /**
     * Definition 2.7 / Theorem 2.2: Permutations
     * 
     * @param n The total number of items to choose from
     * @param r The number of items to choose from n
     * @return The number of unique, ordered groups of size r that can be made from n items
     */
    public BigInteger calculatePermutation(int n, int r) {
        
        BigInteger numerator = factorial(n);
        BigInteger denominator = (factorial(n - r));
        
        return numerator.divide(denominator);
    
    }
    
    
    /**
     * Definition 2.8 / Theorem 2.4: Combinations
     * 
     * @param n The total number of items to choose from
     * @param r he number of items to choose from n
     * @return The number of non-ordered sequences of length r that can be made from n items
     */
    public BigInteger calculateCombination(int n, int r) {
    
        BigInteger numerator = factorial(n);
        BigInteger denominator = (factorial(r).multiply(factorial(n - r)));
        
        return numerator.divide(denominator);
    
    }
    
    
    /**
     * Definition 3.7: Binomial Distribution
     * 
     * @param p The probability of success
     * @param q The probability of failure
     * @param n The number of trials
     * @param y The number of successful trials
     * @return The probability of obtaining y successes in n trials
     */
    public BigDecimal binomialDistribution(double p, double q, int n, int y) {
    	
    	BigDecimal product = BigDecimal.valueOf((Math.pow(p, y)) * (Math.pow(q, (n - y))));
    	
    	return (product.multiply(new BigDecimal(calculateCombination(n, y))));
    	
    }
    

    /**
     * Theorem 3.7: Expected value of binomial distribution
     * 
     * @param p The success rate
     * @param n The number of trials
     * @return The expected value
     */
    public double expectedBinomialDistribution(double p, double n) {
    	
    	return n * p;
    	
    }
    
    /**
     * Theorem 3.7: Variance of binomial distribution
     * 
     * @param p The success rate
     * @param n The number of trials
     * @return The variance
     */
    public double varianceBinomialDistribution(double p, double q, int n) {
    	
    	return n * q * p;
    	
    }
    
    /**
     * Definition 3.8: Geometric Distribution
     * 
     * @param p The probability of success
     * @param q The probability of failure
     * @param y The trial of first success
     * @return The probability of having the first success on trial y
     */
    public double geometricDistribution(double p, double q, int y) {
    	
    	return p * Math.pow(q, y - 1);
    	
    	
    }
    
    /**
     * Theorem 3.8: Expected value of geometric distribution
     * 
     * @param p The success rate
     * @return The average number of trials until first success
     */
    public double expectedGeometricDistribution(double p) {
    
    	return (1 / p);
    
    }
    
    /**
     * Theorem 3.8: Variance of geometric distribution
     * 
     * @param p The success rate
     * @return The variance of when the first success occurs 
     */
    public double varianceGeometricDistribution(double p) {
    
    	return (1 - p) / (Math.pow(p, 2));
    
    }
    
    /**
     * Hypergeometric distribution
     * 
     * @param N The total number of objects
     * @param n The number of objects samples
     * @param k The total number of desired objects
     * @param r The target number of desired objects
     * @return The probability of choosing r from k when choosing n in N
     */
	public double hypergeometricDistribution(int N, int n, int k, int r) {
	
		double numerator = (calculateCombination(k, r).multiply(calculateCombination(N - k, n - r))).doubleValue();
		double denominator = calculateCombination(N, n).doubleValue();
	
		return numerator / denominator;
		
	}

	/**
	 * Hypergeometric expected
	 * 
     * @param N The total number of objects
     * @param n The number of objects samples
     * @param k The total number of desired objects
	 * @return The average value of selecting k objects
	 */
	public double hypergeometricExpected(int N, int n, int k) {
		
		return (double) n * k / N;
		
	}
	
	/**
	 * Hypergeometric Variance
	 * 
     * @param N The total number of objects
     * @param n The number of objects samples
     * @param k The total number of desired objects
	 * @return The variance of selecting k objects
	 */
	public double hypergeometricVariance(int N, int n, int k) {
		
		double numerator = (double) (N - n) * n * k * (N - k);
		double denominator = (double) (N - 1) * N * N;
		
		return numerator / denominator;
		
	}
	
	/**
	 * Negative Binomial Distribution
	 * 
	 * @param y The number of trials
	 * @param r The number of successful trials
	 * @param p The probability of successful trials 
	 * @return The probability of rth success at trial y
	 */
	public double negativeBinomial(int y, int r, double p) {
		
		
		return  calculateCombination(y - 1, r - 1).doubleValue() * Math.pow(p, r) * Math.pow((1 - p), (y - r));
		
	}
	
	/**
	 * Calculates the expected of negative binomial distribution
	 * 
	 * @param r The number of successful trials
	 * @param p The probability of successful trials 
	 * @return The expected probability
	 */
	public double negativeBionmialExpected(int r, double p) {
		
		return (double) r / p;
		
	}
	
	/**
	 * Negative Binomial Variance
	 * 
	 * @param r The number of successful trials
	 * @param p The probability of successful trials 
	 * @return The variance of negative binomial
	 */
	public double negativeBinomialVariance(int r, double p) {
		
		double numerator =  r * (1 - p);
		double denominator = Math.pow(p, 2);
		
		
		return (numerator / denominator); 
		
	}
	
	/**
	 * Poisson Distribution
	 * 
	 * @param lamda The arbitrary ___ value
	 * @return The 
	 */
	public double poissonDistribution(double lamda, int y) {
		
		double numerator = Math.pow(lamda, y) * Math.pow(Math.E, -lamda);
		double denominator = factorial(y).doubleValue();
				
		return numerator / denominator;
	}

	/**
	 * Poisson expected
	 * 
	 * @param r The number of successful trials
	 * @param p The probability of successful trials 
	 * @return The expected probability
	 */
	public double poissonExpected(double lamda) {
		
		return lamda;
		
	}
	
	/**
	 * Poisson variance
	 * 
	 * @param r The number of successful trials
	 * @param p The probability of successful trials 
	 * @return The variance 
	 */
	public double poissonVariance(double lamda) {
		
		return lamda;
		
	}
	
	/**
	 * Tchebysheff rate
	 * 
	 * @param k
	 * @return The odds that data falls within a range 
	 */
	public double getTchebysheffRate(double k) {
		
		return 1 - (1 / Math.pow(k, 2));
		
	}
	
	/**
	 * "Within number" of Tchebysheff
	 * 
	 * @param lower The lower bound
	 * @param upper The upper bound
	 * @param mean The mean
	 * @return The distance between the bounds and mean, 0 otherwise
	 */
	public double getTchebysheffWithin(double lower, double upper, double mean) {
		
		if (upper - mean == mean - lower)
			return upper - mean;
		
		else
			return 0;
		
	}
	
	/**
	 * The Tchebysheff rate given all parameters
	 * 
	 * @param lower The lower bound
	 * @param upper The upper bound
	 * @param mean The mean
	 * @param stdev The standard deviation
	 * @return The odds that data falls within bounds
	 */
	public double getTchebysheffAllParams(double lower, double upper, double mean, double stdev) {
		
		return getTchebysheffRate(getTchebysheffWithin(lower, upper, mean) / stdev);
		
	}
	
	/**
	 * Uniform Distribution CDF Single Point
	 * 
	 * @param point The single point
	 * @param valueRange The range
	 * @return The CDF evaluated at one point
	 */
	public double uniformDistributionSinglePoint(double point, double valueRange) {
		
		return point / valueRange;
		
	}
	
	/**
	 * Uniform Distribution CDF full
	 *  
	 * @param point
	 * @param valueRange
	 * @return The odds that the value falls within the range
	 */
	public double uniformDistributionSinglePoint(double upperPoint, double lowerPoint, double valueRange) {
		
		return (upperPoint - lowerPoint) / valueRange;
		
	}
	
	/**
	 * The normal probability distribution PDF (NOT THE CDF)
	 * 
	 * @param y The single point
	 * @param mean The mean
	 * @param stdev The standard deviation
	 * @return normal probability distribution's PDF evaluated at y with given mean and stdev
	 */
	public double normalProbabilityDistribution(double y, double mean, double stdev) {
		
		double partOne = 1 / (stdev * Math.sqrt(2 * Math.PI));
		
		double exponentNumerator = -Math.pow((y - mean), 2);
		double exponentDenominator = 2 * Math.pow(stdev, 2);
		double partTwo = Math.pow(Math.E, (exponentNumerator / exponentDenominator));
		
		return partOne * partTwo;
	}
	
	/**
	 * The exponential distribution CDF
	 * 
	 * @param point The single point to be evaluated at
	 * @param beta The mean 
	 * @return The exponential distribution CDF evaluated at point
	 */
	public double exponentialSingleCDF(double point, double beta) {
		
		return Math.pow(Math.E, -(point / beta));
		
	}
	
	/**
	 * Common multivariate problem solver -- used for homework
	 * 
	 * @param favorableOne Variable one
	 * @param favorableTwo Variable two
	 * @param chosenOne Instances favorable one
	 * @param chosenTwo Instances favorable two
	 * @param total Total options
	 * @param totalChosen Total selected
	 * @return This particular probability similar to hypergeometric distribution
	 */
	public double commonMultivariateProblem(int favorableOne, int favorableTwo, int chosenOne, int chosenTwo, int total, int totalChosen) {
		
		double numerator = calculateCombination(favorableOne, chosenOne).multiply(calculateCombination(favorableTwo, chosenTwo).multiply(calculateCombination((total - favorableOne - favorableTwo), (totalChosen- chosenOne - chosenTwo)))).doubleValue();
		double denominator = calculateCombination(total, totalChosen).doubleValue();
		
		return numerator / denominator;
		
	}
	
}
