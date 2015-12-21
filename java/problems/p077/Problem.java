package problems.p077;

import lib.StaticSieve;

public class Problem {
	public Problem() {
		int target = 2;           
		int[] primes = StaticSieve.sieve(100);
		           
		while (true) {
		    int[] patterns = new int[target+1];
		    patterns[0] = 1;
		 
		    for (int i = 0; i < primes.length; i++) {                    
		        for (int j = primes[i]; j <= target; j++) {
		            patterns[j] += patterns[j - primes[i]];
		        }
		    }
		                                 
		    if (patterns[target] > 5000) break;
		    target++;
		}
		System.out.println(target);
	}
}