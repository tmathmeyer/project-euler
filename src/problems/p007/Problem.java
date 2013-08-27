package problems.p007;

public class Problem {
	public Problem()
	{
		int c = 0;
		boolean[] vals = new boolean[1000000+1];
		for(int i=2; i <= 1000000; i++)
		{
			if (!vals[i])
			{
				for(int j = i*2; j<=1000000; j+=i)
				{
					vals[j] = true;
				}
				c++;
				if (c == 10001) {
					System.out.println(i);
					return;
				}
			}
		}
	}
}
