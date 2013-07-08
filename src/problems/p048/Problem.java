package problems.p048;

import problems.lib.java.Numbers;

public class Problem {
	public Problem()
	{
		long sum = 0;
		
		for(int i = 1; i <= 1000; i++)
		{
			sum += Numbers.exp_mod_itr_slow(i, i, 10000000000l);
			sum %= 10000000000l;
		}
		System.out.println(sum);
	}
}
