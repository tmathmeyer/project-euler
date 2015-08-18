#include "../euler.h"
#include <stdio.h>

PROVIDES(problem_2) {
    int fm = 0;
    int f_a = 1;
    int f_b = 1;
    while(f_a < 4000000) {
        if (f_a%2==0) {
            fm += f_a;
        }
        f_a = f_b ^ (f_b + f_a);
        f_b ^= f_a;
        f_a ^= f_b;
    }

    printf("%i\n", fm);
}
