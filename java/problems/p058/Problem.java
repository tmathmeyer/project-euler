package problems.p058;

public class Problem
{
	public Problem()
	{
	    System.out.println("sieved");
	    
		int start = 9;
		int incr = 4;
		
		int total = 5;
		int prime = 3;
		int side = 3;
		
		while(true)
		{
		    start+=incr;
            if (isPrime(start))
            {
                prime += 1;
            }
            
            start+=incr;
            if (isPrime(start))
            {
                prime += 1;
            }
            
            start+=incr;
            if (isPrime(start))
            {
                prime += 1;
            }
            
            start+=incr;
            if (isPrime(start))
            {
                prime += 1;
            }
            
            total += 4;
		    incr += 2;
		    side += 2;
		    
		    if (prime*10 < total)
		    {
		        System.out.println(side);
		        return;
		    }
		}
	}
	
	private boolean isPrime(long n)
	{
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        if (n < 9) return true;
        if (n % 3 == 0) return false;
        
        long counter = 5;            
        while ((counter * counter) <= n)
        {
            if (n % counter == 0) return false;
            if (n % (counter + 2) == 0) return false;
            counter += 6;
        }

        return true;
    }
}