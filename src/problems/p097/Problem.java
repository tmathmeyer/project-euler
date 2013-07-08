package problems.p097;

import problems.lib.java.Numbers;

public class Problem {
	public Problem()
	{
		long r = Numbers.exp_mod_itr_slow(2, 7830457, 10000000000l);
		r *= 28433;
		r += 1;
		System.out.println(r%10000000000l);
	}
}
