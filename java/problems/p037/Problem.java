package problems.p037;

import lib.Numbers;

public class Problem {
	int[] i = new int[10000000];
	public Problem()
	{
		for(int x = 2; x < 10000000; x++)
		{
			if (i[x] == 0)
			{
				for(int k = 2*x; k < 10000000; k += x)
				{
					i[k] = 1;
				}
				if (!(x%10==7 || x%10==3))
				{ //failed the end number check
					i[x] = 2;
				}
				else
				{
					int q = Numbers.pow(10, (x+"").length()-1);
					if (!(x/q==7 || x/q==3 || x/q==5 || x/q==2))
					{ //does not start with 3 or 7 or 5
						i[x] = 3;
					}
					else if (!isForewardPrime(x))
					{ //does not start with 
						i[x] = 4;
					}
					else if (!isBackwardsPrime(x))
					{
						i[x] = 5;
					}
				}
			}
		}
		int sum = 0;
		for(int x = 10; x < 10000000; x++)
		{
			if (x==0)sum+=x;
		}
		System.out.println(sum);
	}
	
	public boolean isForewardPrime(int i)
	{ //1234 -> 123 -> 12 -> 1
		if (i < 10) return true;
		if (this.i[i] == 1)return false;
		return isForewardPrime(i/10);
	}
	
	public boolean isBackwardsPrime(int i)
	{//1234 -> 234 -> 34 -> 4
		if (i < 10) return true;
		if (this.i[i] == 1)return false;
		return isBackwardsPrime(i % Numbers.pow(10, (i+"").length()-1));
	}
}
