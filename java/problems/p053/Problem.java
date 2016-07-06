package problems.p053;

import lib.Real;

public class Problem
{
    public static final int THRESHOLD = 1000000;
    
	public Problem()
	{
	    int total = 0;
	    
		for(int n = 2; n <= 100; n++)
		{
		    for(int r = 0; r < n/2; r++)
		    {
		        if (c(n, r).greaterThan(THRESHOLD))
		        {
		            total += (n-2*r+1);
                    r = n;
		        }
		    }
		}
		System.out.println(total);
	}
	
	private Real c(int n, int r)
	{
	    int big = r>r-n?r:r-n;
	    
	    Real res = new Real(1);
	    for(int i=n; i>big;i--)
	    {
	        res = res.divide(new Real(i-big));
	        res = res.multiply(new Real(i));
	    }
	    return res;
	}
}
