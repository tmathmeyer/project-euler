package problems.p033;

public class Problem {
	
	public Problem()
	{
		int n = 1;
		int d = 1;
		for (int num = 1; num < 100; num++)
		{
			for(int dem = num+1; dem < 100; dem++)
			{
				if ((num%10 == dem/10) && (dem%10 * num == (num/10) * dem))
				{
					if (dem%10 != 0)
					{
						n *= num;
						d *= dem;
					}
				}
			}
		}
		System.out.println(d/n);
	}
}
