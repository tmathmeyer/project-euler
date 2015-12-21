package problems.p051;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import lib.Sieve;
import lib.StaticSieve;

public class Problem
{
    private static final int THRESHOLD = 8;
    
	public Problem()
	{
		Sieve primes = new StaticSieve(1000000);
		primes.setNextPrimeLocation(1l);
		
		Set<String> failures = new HashSet<String>();
		
		Long l;
		while((l = primes.nextPrime()) < 1000000)
		{
		    for(String e : getRegexFor(l))
		    {
		        if (!failures.contains(e))
		        {
		            if (countPrimes(primes, e) < THRESHOLD)
		            {
		                failures.add(e);
		            }
		            else
		            {
		                System.out.println(e);
		                listPrimes(primes, e).forEach(A -> System.out.println(A));
		                return;
		            }
		        }
		    }
		}
	}
	
	
	
	public int countPrimes(Sieve p, String r)
	{
        return (int) listPrimes(p, r).count();
	}
	
	public Stream<Long> listPrimes(Sieve p, String r)
	{
	    return new LinkedList<Integer>(){{for(int i=0;i<10;i++){add(i);}}}
        .stream()
        .map(A -> {
            return Long.parseLong(r.replaceAll("X", A+""));
        })
        .filter(A -> {
            return r.length()==(A+"").length() && p.isPrime(A);
        });
	}
	
	public List<String> getRegexFor(Long l)
	{
	    return new LinkedList<String>()
	    {{
	        for(int i=0;i<3;i++)
	        {
	            String x = l.toString().replaceAll(i+"", "X");
	            if (x.contains("X"))
	            {
	                add(x);
	            }
	        }
	    }};
	}
}
