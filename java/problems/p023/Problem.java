package problems.p023;

import java.io.FileNotFoundException;

public class Problem {
	int abd[] = new int[6967];
	
	public Problem() throws FileNotFoundException
	{
		java.util.Scanner f = new java.util.Scanner(new java.io.File("abundantNumbers.txt"));
		for(int i = 0; i < 6967; i++)
		{
			abd[i] = f.nextInt();
		}
		
		int[] nums = new int[28124];
		
		for(int x = 0; x < 6967; x++)
		{
			for(int y = 0; y < 6967; y++)
			{
				int k = abd[x]+abd[y];
				if (k < 28124)nums[k] = 1;
			}
		}
		
		int sum = 0;
		for(int i = 0; i < 28124; i++)
		{
			if (nums[i] == 0)
			{
				sum += i;
			}
		}
		System.out.println(sum);
		f.close();
		
	}
}
