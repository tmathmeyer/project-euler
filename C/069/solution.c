#include "../euler.h"
#include <math.h>
#include <stdio.h>
 
PROVIDES(problem_69) {
    double maxium = 1;
    int max = 1;
    int top = 10;
    int current = 2;

    while(current <= top){
    	int value = current;
    	double count = current;
    	int i = 2;
    	while(i < sqrt(value)){
    		while(value%i==0){
    			value /= i;
    		}
    		count -= current/i;
    		i++;
    	}

    	if (count / current > maxium) {
    		max = current;
        }
    	current++;
    }

    printf("%i%f\n", max, maxium);
}
