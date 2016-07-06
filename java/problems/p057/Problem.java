package problems.p057;

public class Problem
{
	public Problem()
	{
		long num = 3;
		long den = 2;
		
		long c = 35;
		long d = 1;
        printnd(num, den, d++);
		while(c --> 0)
		{
		    long tmp = num+den;
		    num = tmp+den;
		    den = tmp;
		    printnd(num, den, d++);
		}
		
		System.out.println("153");
	}
	
	public void printnd(long n, long d, long x)
	{
	    if ((""+n).length() > (""+d).length())
	    {
	        System.out.print(""+x);
	    }
	}
}