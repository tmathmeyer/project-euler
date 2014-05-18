#include <iostream>
#include <vector>
#include <math.h>
using namespace std;
 
int main()
{
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

    	if (count / current > maxium)
    		max = current;
    	current++;
    }

    cout << max << "" << maxium << endl;
}