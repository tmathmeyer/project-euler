#ifndef __EULER__
#define __EULER__

void reg_sol(int number, void (*problem)());
void solve(int number);
char *provide();
void collect();

#define PROVIDES(str) char *provide(){return #str;} void str()

#endif
