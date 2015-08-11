#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "euler.h"

#define MAX 600
#define match(str) if (!strncmp(str, input, size))
void (**problems)();

int main() {
    problems = malloc(MAX * sizeof(void *));
    collect();
    
    char input[16];
    memset(input, 0, 16);
    int size = 0;
    do {
        printf(">");
        char *res = fgets(input, sizeof(input), stdin);
        if (!res) {
            return 0;
        }
        size = (strlen(res) > sizeof(input) ? sizeof(input) : strlen(res)) - 1;
        match("help") {
            puts("type a number to see that problem's solution");
            puts("or type list to list all availible problems");
            puts("or quit to exit");
        }
        else match("list") {
            for(int i=0; i<MAX; i++) {
                if (problems[i]) {
                    printf("%i\n", i);
                }
            }
        }
        else match("quit") {
            exit(0);
        }
        else {
            solve(atoi(input));
        }
        puts("");
    } while(size);
}

void reg_sol(int number, void (*problem)()) {
    if (number > MAX) {
        printf("cant load problem %i\n", number);
    }
    problems[number] = problem;
}

void solve(int number) {
    if (number > MAX) {
        printf("project euler does not have that many problems");
        return;
    }
    void (*problem)() = problems[number];
    if (problem) {
        problem();
    } else {
        printf("problem %i has not been completed\n", number);
    }
}
