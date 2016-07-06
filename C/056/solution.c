#include "../euler.h"
#include <stdio.h>

int sum_a_pow_b(int a, int b) {
    char digits[200] = {0};
    digits[0] = 1;
    int pos;
    while(b-->0) {
        int carry = 0;
        pos = 0;
        do {
            int mult = digits[pos] * a + carry;
            digits[pos] = mult % 10;
            carry = mult / 10;
            pos ++;
        } while(pos < 200);
    }
    int sum = 0;
    for(int i=199;i>=0;i--) {
        sum += (digits[i]);
    }
    return sum;
}

PROVIDES(problem_56) {
    int a, b, max=0;
    for(a=0;a<100;a++) {
        for(b=0;b<100;b++) {
            int x = sum_a_pow_b(a, b);
            max=x>max?x:max;
        }
    }
    printf("%i\n", max);
}
