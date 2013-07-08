package problems.lib.java;

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
	
	private static boolean isPrime(int i, int top){
		return top==1 ? true : (i%top==0 ? false : isPrime(i,top-1));
	}
	
	public static boolean isPrime(long n)
	{//fermats :D
	  if (n%2==0 || n%3==0)
		{
			return false;
		}
		boolean res = true;
		for (long a = 2; a<n; a*=2)
		{
			res = res&&exp_mod_itr(a,n,n)==a;
		}
		return res;
	}
	
	public static ArrayList<Integer> listAllPrimeFactors(int i){
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (isPrime(i)){
			res.add(i);
			return res;
		}
		for (int j = 2; j < i/2; j++){
			if (i%j==0){
				res.add(j);
				res.addAll(listAllPrimeFactors(i/j));
				j=i;
			}
		}
		return res;
	}
	
	public static ArrayList<Integer> listPrimeFactors(int i){
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<Integer> all = listAllPrimeFactors(i);
		for (int j: all)if (!result.contains(j))result.add(j);
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
