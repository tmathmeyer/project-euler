package test;

import static org.junit.Assert.*;

import org.junit.Test;

import lib.LazySieve;
import lib.StaticSieve;
import lib.Sieve;

public class LazySieveTest
{

    @Test
    public void primes()
    {
        LazySieve s = new LazySieve();
        
        assertTrue(s.isPrime(2l));
        assertTrue(s.isPrime(5l));
        assertTrue(s.isPrime(7l));
        assertTrue(s.isPrime(56003l));
        assertTrue(s.isPrime(100019l));
        assertTrue(s.isPrime(100003l));
    }
    
    @Test
    public void nextPrime()
    {
        Sieve s = new LazySieve();
        assertEquals(s.nextPrime()+0, 2);
        assertEquals(s.nextPrime()+0, 3);
        assertEquals(s.nextPrime()+0, 5);
        assertEquals(s.nextPrime()+0, 7);
        
        s = new StaticSieve(100);
        assertEquals(s.nextPrime()+0, 2);
        assertEquals(s.nextPrime()+0, 3);
        assertEquals(s.nextPrime()+0, 5);
        assertEquals(s.nextPrime()+0, 7);
    }
    
    @Test
    public void testIsPrime()
    {
        Sieve s = new StaticSieve(100);
        assertTrue(s.isPrime(71l));
        assertFalse(s.isPrime(91l));
    }

}
