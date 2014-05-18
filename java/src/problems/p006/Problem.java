package problems.p006;

public class Problem {
	public Problem()
	{
		long x = 0;
		long y = 0;
		for (int i = 1; i <= 100; i++){
			x+=i;
			y+=(i*i);
		}
		x *= x;
		System.out.println(x-y);
	}
}
