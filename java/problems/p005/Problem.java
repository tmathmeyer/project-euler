package problems.p005;

import lib.Numbers;

public class Problem {
	public Problem()
	{
		int j = 2520;
		for (int i = 11; i < 20; i++)j = Numbers.lcm(j,i);
		System.out.println(j);
	}
}
