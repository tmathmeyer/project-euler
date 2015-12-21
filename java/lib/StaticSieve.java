package lib;

import java.util.Set;

public class StaticSieve implements Sieve
{
    private final int[] sieve;
    private int pindex = -1;
    
    public StaticSieve(int top)
    {
        sieve = sieve(top);
    }
    
    @Override
    public boolean isPrime(Long L)
    {
        int min = 0;
        int max = sieve.length;
        while(max - min > 1)
        {
            int check = (min+max)/2;
            if (check > sieve.length-1 || check < 0)
            {
                return false;
            }
            if (sieve[check] == L)
            {
                return true;
            }
            if (sieve[check] > L)
            {
                max = check;
            }
            if (sieve[check] < L)
            {
                min = check;
            }
        }
        if (max > 0 && max < sieve.length)
        {
            if (sieve[max] == L)
            {
                return true;
            }
        }
        if (min > 0 && min < sieve.length)
        {
            if (sieve[min] == L)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public Set<Long> uniquePrimeFactors(Long L)
    {
        throw new RuntimeException("uniquePrimeFactors not implemented on RawSieve");
    }

    @Override
    public Long nextPrime()
    {
        if (pindex < sieve.length)
        {
            return (long) sieve[++pindex];
        }
        throw new RuntimeException("out of generated sieve length");
    }

    @Override
    public void setNextPrimeLocation(Long l)
    {
        pindex = (int) (l+0);
    }
    
    
    
	public static int[] sieve(int top)
	{
		boolean[] vals = new boolean[top+1];
		IL l = new IL(2);
		for(int i=2; i <= top; i++)
		{
			if (!vals[i])
			{
				for(int j = i*2; j<=top; j+=i)
				{
					vals[j] = true;
				}
				if (i != 2)
				{
					IL k = new IL(i, l);
					l = k;
				}
			}
		}
		
		int[] res = new int[l.k];
		for(int i = res.length-1; i>=0; i--)
		{
			res[i] = l.v;
			l = l.l;
		}
		return res;
	}
}

class IL 
{
	IL l;
	int k;
	int v;
	public IL(int val, IL l) {
		this.v = val;
		this.l = l;
		this.k = l.k+1;
	}
	
	public IL(int v)
	{
		this.v = v;
		this.k = 1;
	}
}