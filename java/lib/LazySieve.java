package lib;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LazySieve implements Sieve
{
    private final Set<Long> primes = new HashSet<>();
    private Long maxCheck = 6l;
    private Long nextPrime = 1l;
    
    public LazySieve()
    {
        primes.add(2l);
        primes.add(3l);
        primes.add(5l);
    }
    
    private boolean doPrimeCheck(Long L)
    {
        for(Long t : primes)
        {
            if (L%t == 0)
            {
                return false;
            }
        }
        primes.add(L);
        return true;
    }
    
    @Override
    public boolean isPrime(Long L)
    {
        if (L < 2)
        {
            return false;
        }
        if (L < maxCheck)
        {
            return primes.contains(L);
        }
        
        boolean finalPrime = false;
        while(maxCheck <= L)
        {
            finalPrime = doPrimeCheck(maxCheck);
            maxCheck++;
        }
        return finalPrime;
    }
    
    @Override
    public Set<Long> uniquePrimeFactors(Long L)
    {
        if (isPrime(L))
        {
            return new HashSet<Long>(){{
                add(L);
            }};
        }
        return primes.stream().filter(P -> {
            return L%P == 0;
        }).collect(Collectors.toSet());
    }
    
    @Override
    public Long nextPrime()
    {
        while(!isPrime(nextPrime))
        {
            nextPrime++;
        }
        nextPrime++;
        return nextPrime-1;
    }
    
    @Override
    public void setNextPrimeLocation(Long l)
    {
        nextPrime = l;
    }
}
