package lib;

import java.util.ArrayList;

public class Numbers {

	/**
	 * @param a
	 * @param b
	 *
	 *
	 * returns a^b
	 *
	**/
	public static int pow(int a, int b)
	{ // a^b
		if (b==0)
		{
			return 1;
		}
		if (b==1)
		{
			return a;
		}
		if (b%2 == 0)
		{
			return pow(a*a, b/2);
		}
		return a * pow (a, b-1);
	}

	public static long exp_mod_itr(long a, long b, long c)
	{
		if (c==0)
		{
			return 0; //because you're clearly too stupid to do math
		}
		if (b==0)
		{
			return 1;
		}
		if (a==0)
		{
			return 0; //why are you even here
		}
	 
		long result = a%c;
		int k = 1;
	 
		while(b > k)
		{
			if ((b-k)%2==0 && k*2<=b)
			{
				result *= result;
				k *= 2;
			}
			else
			{
				result *= (a%c);
				k += 1;
			}
			result %= c;
		}
		return result;
	}
	
	public static long exp_mod_itr_slow(long a, long b, long c)
	{
		long result = 1;
		for(int i = 0; i < b; i++)
		{
			result *= a;
			result %= c;
		}
		return result;
	}
	
	public boolean[] sieve(int top)
	{
		boolean[] vals = new boolean[top+1];
		IL l = new IL(2);
		for(int i=2; i <= top; i++)
		{
			if (!vals[i])
			{
				for(int j = i*2; j<=top; j+=i)
				{
					vals[j] = true;
				}
				if (i != 2)
				{
					IL k = new IL(i, l);
					l = k;
				}
			}
		}
		return vals;
	}


	/**
	 * @param n1
	 * @param n2
	 *
	 *
	 * returns the greatest common denominator
	 *
	**/
	public static int gcd(int n1, int n2){
		return n2==0 ? n1 : (n1<n2 ? gcd(n2,n1) : gcd(n2,n1%n2));
	}
	
	public static int lcm(int n1, int n2) {
		return (n1*n2)/gcd(n1,n2);
	}
	
	public static boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        if (n < 9) return true;
        if (n % 3 == 0) return false;
        
        long counter = 5;            
        while ((counter * counter) <= n) {
            if (n % counter == 0) return false;
            if (n % (counter + 2) == 0) return false;
            counter += 6;
        }

        return true;
    }
	
	public static ArrayList<Long> listAllPrimeFactors(long i){
		ArrayList<Long> res = new ArrayList<>();
		if (isPrime(i)){
			res.add(i);
			return res;
		}
		for (long j = 2; j < i/2; j++){
			if (i%j==0){
				res.add(j);
				res.addAll(listAllPrimeFactors(i/j));
				j=i;
			}
		}
		return res;
	}
	
	public static ArrayList<Long> listPrimeFactors(Long i){
		ArrayList<Long> result = new ArrayList<>();
		ArrayList<Long> all = listAllPrimeFactors(i);
		for (Long j: all)if (!result.contains(j))result.add(j);
		return result;
	}
	
	public static ArrayList<Integer> ListAllFactors(int i){
		ArrayList<Integer> res = new ArrayList<Integer>();
		res.add(1);
		for (int j = 2; j <=Math.sqrt(i) ; j++){
			if (i%j==0){
				if (!res.contains(j))res.add(j);
				if (!res.contains(i/j))res.add(i/j);
			}
		}
		return res;
	}
	
}
