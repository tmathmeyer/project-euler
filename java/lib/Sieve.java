package lib;

import java.util.Set;

public interface Sieve
{   
    boolean isPrime(Long L);
    
    Set<Long> uniquePrimeFactors(Long L);
    
    Long nextPrime();
    
    void setNextPrimeLocation(Long l);
}
