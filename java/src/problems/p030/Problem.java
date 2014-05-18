package problems.p030;

import problems.lib.java.Numbers;

public class Problem {
	public Problem()
	{
		int[] fives = new int[10];
		for(int i = 0; i < 10; i++)
		{
			fives[i] = Numbers.pow(i, 5);
		}
		int sup = 0;
		for(int i = 2; i < 999999; i++)
		{
			int sum = 0;
			for(int j = 0; j < (i+"").length(); j++)
			{
				int digit = Integer.parseInt((i+"").charAt(j)+"");
				sum += fives[digit];
				if (sum > i)
				{
					j = 1324098;
				}
			}
			if (sum == i && i != 59049)
			{
				sup+=sum;
			}
		}
		System.out.println(sup);
	}
}
