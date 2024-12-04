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
    public double binomialDistributionExpected(double p, double n) {
    	
    	return n * p;
    	
    }
    
    /**
     * Theorem 3.7: Variance of binomial distribution
     * 
     * @param p The success rate
     * @param n The number of trials
     * @return The variance
     */
    public double binomialDistributionVariance(double p, double q, double n) {
    	
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
    public double geometricDistributionExpected(double p) {
    
    	return (1 / p);
    
    }
    
    /**
     * Theorem 3.8: Variance of geometric distribution
     * 
     * @param p The success rate
     * @return The variance of when the first success occurs 
     */
    public double geometricDistributionVariance(double p) {
    
    	return (1 - p) / (Math.pow(p, 2));
    
    }
    
    /**
     * 
     * 
     * @param N The total number of objects
     * @param n The number of objects samples
     * @param k The total number of desired objects
     * @param r The target number of desired objects
     * @return
     */
	public double hyperGeometricDistribution(int N, int n, int k, int r) {
	
		double numerator = calculateCombination(k, r).doubleValue() * calculateCombination(N, n-r).doubleValue();
		double denominator = calculateCombination(N, n).doubleValue();
	
		return numerator / denominator;
		
	}

	/**
	 * The expected value of hypergeometric distribution
	 * 
	 * @param N
	 * @param n
	 * @param k
	 * @return
	 */
	public double hyperGeometricExpected(int N, int n, int k) {
		
		return (double) n * k / N;
		
	}
	
	/**
	 * The variance of hypergeometric distribution
	 * 
	 * @param N
	 * @param n
	 * @param k
	 * @return
	 */
	public double hyperGeometricVariance(int N, int n, int k) {
		
		double numerator = (N - n) * n * k * (N - k);
		double denominator = (N - 1) * N * N;
		
		return numerator = denominator;
		
	}
	
	/**
	 * Calculates Negative Binomial Distribution
	 * 
	 * @param y The number of trials
	 * @param r The number of successful trials
	 * @param p The probability of successful trials 
	 * @return The probability of rth success at trial y
	 */
	public double negativeBinomialDistribution(int y, int r, int p) {
		
		
		return  calculateCombination(y - 1, r - 1).doubleValue() * Math.pow(p, r) * Math.pow((1 - p), (y - r));
		
	}
	
	/**
	 * Calculates the expected of negative binomial distribution
	 * 
	 * @param r The number of successful trials
	 * @param p The probability of successful trials 
	 * @return The expected probability
	 */
	public double negativeBionmialExpected(int r, int p) {
		
		return (double) r / p;
		
	}
	
	/**
	 * 
	 * 
	 * @param r The number of successful trials
	 * @param p The probability of successful trials 
	 * @return The average variance of the expected probability
	 */
	public double negativeBinomialVariance(int r, int p) {
		
		double numerator =  (double) r * (1 - p);
		double denominator = Math.pow(r, 2);
		
		
		return (numerator / denominator); 
		
	}
	
	/**
	 * Calculates the Poisson Distribution
	 * 
	 * @param lamda The arbitrary ___ value
	 * @return The 
	 */
	public double calculatePoissonDistribution(double lamda) {
		
		
		return 2.0;
	}

	
	public double uniformDistribution(double rangeStart, double rangeEnd, double begin, double end) {

	
	}
	
}
