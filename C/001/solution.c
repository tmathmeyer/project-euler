#include "../euler.h"
#include <stdio.h>

PROVIDES(problem_1) {
    int sum = 0;
    int each = 0;
    while(each < 1000) {
        if (each%5==0 || each%3==0) {
            sum+=each;
        }
    }
    printf("%i\n", sum);
}
