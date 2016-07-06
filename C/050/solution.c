#include "../euler.h"

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

struct tup {
	long long a;
	long long b;
};

int* make_sieve(int length, int* len);
int* filterprimes(int* sieve, int max, int count);
long long* count_sums(int* primes, int length);
int iterative_max(int* sieve, long long* sums, int primecount, long long maxprime);

PROVIDES(problem_50) {
	printf("segfaulting. incomplete");
    return;
    int length=0, max=1000000;
	int* sieve = make_sieve(max, &length);
	int* primes = filterprimes(sieve, max, 4920);
	long long* sums = count_sums(primes, 4920);

	printf("%i\n", iterative_max(sieve, sums, 4920, max));
}

int* make_sieve(int length, int* len) {
	//1 is prime, 0 is not
	int* sieve = malloc(sizeof(int) * length);
	memset(sieve, 1, length*sizeof(int));
	sieve[0] = 0;
	sieve[1] = 0;

	int i,j;
	for(i=0;i<length;i++) {
		if (sieve[i]) {
			sieve[i] = 1;
			len[0] = len[0] + 1;
			for(j=i*2;j<length;j+=i) {
				sieve[j] = 0;
			}
		}
	}
	return sieve;
}


int* filterprimes(int* sieve, int max, int count) {
	int* primes = malloc(sizeof(int) * count);
	int i,j=-1;
	for (i=0;i<max;i++) {
		if(sieve[i]) {
			primes[++j] = i;
		}
	}
	return primes;
}


long long* count_sums(int* primes, int length) {
	long long* sums = malloc(sizeof(long long) * length);
	sums[0] = 0;
	int i;
	for(i=1;i<length;i++) {
		sums[i] = sums[i-1]+primes[i-1];
	}
	return sums;
}

int iterative_max(int* sieve, long long* sums, int primecount, long long maxprime) {

	int size = primecount/7;
	size *= primecount;
	
	struct tup* primes = calloc(sizeof(struct tup), size);
	int i,j,c=0,k=0;
	for(i=0;i<primecount/2;i++) { // i is low
		for(j=i;j<primecount/2;j++) { // j is hi
			struct tup a = {j-i, sums[j] - sums[i]};
			if (a.b < maxprime || a.b > 0) {
				primes[c++] = a;
			}
		}
	}

	struct tup top = {0, 0};

	for(i=0;i<size;i++) {
		long long maybe = primes[i].b;
		long long range = primes[i].a;

		if (range > top.a) {
			if (maybe<maxprime && sieve[maybe]) {
				top = primes[i];
			}
		}
	}

	return top.b;
}



