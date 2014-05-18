package problems.p077;

import problems.lib.java.Sieve;

public class Problem {
	public Problem() {
		int target = 2;           
		int[] primes = Sieve.sieve(100);
		           
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