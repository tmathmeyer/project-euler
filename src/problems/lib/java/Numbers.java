package problems.lib.java;

import java.util.ArrayList;

public class Numbers {
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
	
	public static int gcd(int n1, int n2){
		return n2==0 ? n1 : (n1<n2 ? gcd(n2,n1) : gcd(n2,n1%n2));
	}
	
	public static int lcm(int n1, int n2) {
		return (n1*n2)/gcd(n1,n2);
	}
	
	private static boolean isPrime(int i, int top){
		return top==1 ? true : (i%top==0 ? false : isPrime(i,top-1));
	}
	
	public static boolean isPrime(int i){
		return isPrime(i, (int)(Math.sqrt(i)));
	}
	
	public static long factorial(int i){
		return i==0 ? 1 : i*factorial(i-1);
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
