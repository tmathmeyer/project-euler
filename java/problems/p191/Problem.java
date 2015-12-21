package problems.p191;


public class Problem
{
	int[] lst = {1, 3, 0, 2, 1, 0, 0, 1};
	
	public void p(int k)
	{
		while (lst[0] < k)
		{
			int n=lst[0], t=lst[1], a=lst[2], b=lst[3], c=lst[4], d=lst[5], e=lst[6], f=lst[7];
			int[] lst2 = {n + 1, 2 * t + b - a, c, 2 * b - a + d, t - (a + c), e, f, t};
			this.lst = lst2;
		}
		System.out.println(lst[1]);
	}
	
	public Problem()
	{
		p(30);
	}
}