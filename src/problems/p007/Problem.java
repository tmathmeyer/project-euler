package problems.p007;

import problems.lib.java.Numbers;

public class Problem {
	public Problem()
	{
		int i = 0;
		int c = 1;
		while(i != 10001){
			c++;
			if (Numbers.isPrime(c))i++;
		}
		System.out.println(c);
	}
}
