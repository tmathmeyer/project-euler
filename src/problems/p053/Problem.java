package problems.p053;

public class Problem {
	public boolean factGMil(int n, int r)
	{
		int fact = fact(n, n-r);
		if (fact == 0)return true;
		return fact / fact(r, 0) > 1000000;
	}
	
	public int fact(int top, int bot)
	{
		long res = 1;
		while(top > bot && res > 0)
			res *= top--;
		return (int) (res>0?res:0);
	}
	
	public Problem()
	{
		
		int total = 0;
		for(int n = 1; n < 23; n++)
		{
			int r = 0;
			int k = 0;
			for(; r*2 < n; r++)
			{
				if (this.factGMil(n, r))
					k++;
			}
			total+=k*2;
			if (r*2>=n)
				total += this.factGMil(n, n/2)?1:0;
		}
		System.out.println(total);
		
		System.out.println(this.factGMil(23, 9));
	}
}
