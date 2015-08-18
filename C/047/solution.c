#include "../euler.h"

#include <stdio.h>
#include <stdlib.h>

#define uint unsigned int

uint *sieve(int size) {
	uint *integers = calloc(size, sizeof(uint));
	int ct = 2;
	integers[0] = integers[1] = 1;
	while(ct < size) {
		if (!integers[ct]) {
			int x = ct*2;
			while(x < size) {
				integers[x] = integers[x]?integers[x]:ct;
				x += ct;
			}
		}
		ct++;
	}
	return integers;
}

int primefactorcount(uint *primes, uint num, int* mark) {
	if (primes[num] == 0) {
		int ct = 0;
		while(mark[ct]) {
			if (mark[ct++] == num) {
				return 0;
			}
		}
		return 1;
	}
	int ct = 0;
	while(mark[ct]) {
		if (mark[ct] == primes[num]) {
			return primefactorcount(primes, num/primes[num], mark);
		}
		ct++;
	}
	mark[ct] = primes[num];
	return 1+primefactorcount(primes, num/primes[num], mark);
}

PROVIDES(problem_47) {
	uint *primes = sieve(10000000);
	uint mark[10] = {0};
	int i = 2;

	int find = 0;
	int first = 0;

	while(i < 10000000) {
		int pr = primefactorcount(primes, i, mark);
		if (pr == 4) {
			find++;
			first = pr;
			printf("factors (%i): %i\n", i, pr);
		} else {
			find = 0;
		}
		while(pr --> 0) {
			mark[pr] = 0;
		}
		if (find == 4) {
		    break;
        }
		i++;
	}
}
