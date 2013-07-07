package problems.p429;

import problems.lib.java.Numbers;
import problems.lib.java.Sieve;

public class Problem 
{
	public Problem()
	{
		int max = 100000000;
		long MODULUS = 1000000009;
		int[] primes = Sieve.largeSieve(max);
		long sum = 1;
		
		System.out.println("starting analysis");
		for(int p : primes)
		{
			int power = countFactors(max, p);
			sum *= 1 + Numbers.exp_mod_itr(p, power * 2, MODULUS);
			sum %= MODULUS;
		}

		System.out.println(sum);
	}



	private int countFactors(int end, int n) {
		int sum = 0;
		while(end != 0)
		{
			int k = end / n;
			sum += k;
			end = k;
		}
		return sum;
	}
}