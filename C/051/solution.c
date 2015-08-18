#include "../euler.h"
#include <stdio.h>
#include <string.h>

#define pnum(x) printf("%i\n", (x))

typedef struct siv {
    int count_on[256];
    int prime;
} siv;

int replace_digits(int num, int from, int to, int *dg);
void replace_all_digits(int num);
#define MAX 1000000

siv sieve[MAX];

PROVIDES(problem_51) {
    memset(sieve, 0, sizeof(siv)*MAX);
    sieve[0].prime = sieve[1].prime = 1;
    int sieve_count = 2;
    int maxnum = 0;
    int max = 0;

    while(sieve_count < MAX) {
        if(!sieve[sieve_count].prime) { // if it's prime
            int killer = sieve_count*2;
            while(killer < MAX) {
                sieve[killer].prime = 1; // set not prime
                killer += sieve_count;
            }
            replace_all_digits(sieve_count);
        }
        sieve_count++;
    }
}

int replace_digits(int num, int from, int to, int *dr) {
    if (from <= to) {
        return 0;
    }
    to = from-to;
    int result = num;
    int pow = 1;
    int dg = 0;
    while(pow < num) {
        if ( (num/pow)%10 == from ) {
            result -= (pow*to);
            dr[dg] = 1;
        }
        pow *=10;
        dg++;
    }
    return result;
}

int magc(int x, int y) {
    while(x && y) {
        x/=10;
        y/=10;
    }
    return !(x || y);
}

int a2b(int *x) {
    int r = 0;
    for(int i=0; i<8; i++) {
        if (x[i]) {
            r+=(1<<i);
        }
    }
    return r-1;
}



int max = 0;
int maxnum = 0;
void replace_all_digits(int num) {
    int vals[10] = {0};
    int temp = num;
    while(temp) {
        vals[temp%10] = 1;
        temp /= 10;
    }
    for(int i=0; i<10; i++) {
        if (vals[i]) {
            for(int j=0; j<i; j++) {
                int digits[8] = {0};
                int res = replace_digits(num, i, j, digits);
                int c = a2b(digits);
                if (magc(res, num) && !sieve[res].prime) {
                    if (res == 56003) {
                        printf("%i ==> (%i -> %i) ==> %i   ::   %i<%i>", num, i, j, res, c, (sieve[res].count_on)[c]+1);
                        getchar();
                    }
                    
                    (sieve[res].count_on)[c] ++;
                    if ((sieve[res].count_on)[c] >= max) {
                        max = (sieve[res].count_on)[c];
                        maxnum = res;
                        printf("%i --->  %i\n", maxnum, max+1);
                    }
                }
            }
        }
    }
}
