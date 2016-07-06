#include "../euler.h"
#include <stdio.h>

PROVIDES(problem_78) {
    int values[100000] = {0};
    values[0] = 1;

    int number = 1;            
    while(1){
        int i = 0;
        int penta = 1;
        values[number] = 0;

        while (penta <= number){                    
            int sign = i%4<2 ? 1:-1;
            values[number] += sign*values[number-penta];
            values[number] %= 1000000;
            i++;

            int j = (i%2==1) ? -(i/2+1):i/2+1;
            penta = j*(3*j-1)/2;
        } 

        if (values[number] == 0) break;
        number++;
    }

    printf("%i\n", number);
}
