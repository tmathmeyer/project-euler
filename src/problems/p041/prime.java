package problems.p041;

public class prime
{
	public static boolean isPrime(long n)
	{//fermats :D
		if (n%2==0 || n%3==0)
		{
			return false;
		}
		boolean res = true;
		for (long a = 2; a<n; a*=2)
		{
			res = res&&exp_mod_itr(a,n,n)==a;
		}
		return res;
	}

	public static long exp_mod_itr(long a, long b, long c)
	{
		if (c==0)
		{
			throw new RuntimeException(); //because you're clearly too stupid to do math
		}
		if (b==0)
		{
			return 1;
		}

		long result = a%c;
		int k = 1;

		while(b > k)
		{
			if ((b-k)%2==0 && k*2<=b)
			{
				result *= result;
				k *= 2;
			}
			else
			{
				result *= (a%c);
				k += 1;
			}
			result %= c;
		}
		return result;
	}



	public static void main(String[] args)
	{
		//System.out.println(exp_mod_itr(2,6,10));
		int i = 3;
		while(i++ < 100)
		{
			if (isPrime(i))
				System.out.println(i);
		}
	}
}