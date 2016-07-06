#include <primecount.hpp>
#include <iostream>

int64_t fn_7(int64_t N);
int64_t fn_31(int64_t N);
int64_t fn_111(int64_t N);

int main()
{
    uint64_t n = 1000000000000;
    int64_t result = fn_7(n) + fn_31(n) + fn_111(n);

    std::cout << "solution = " << result << std::endl;

    return 0;
}


int64_t fn_7(int64_t N) {
    int i = 1;
    do{
        int64_t prime = primecount::nth_prime(i);
        int64_t prime3 = prime*prime*prime;
        int64_t prime7 = prime3*prime3*prime;
        if (prime7>N) {
            std::cout << "fn_7 = " << i-1 << std::endl;
            return i-1;
        }
        i++;
    } while(1);
}

int64_t fn_31(int64_t n) {
    int64_t i = 1;
    int64_t count = 0;

    do {
        int64_t prime = primecount::nth_prime(i);
        int64_t prime3 = prime*prime*prime;
        if (prime3 > n) {
            std::cout << "fn_31 = " << count << std::endl;
            return count;
        }

        int64_t max = n / prime3;
        int64_t mults = primecount::pi(max);

        if (max >= prime) {
            mults -= 1;  //subtract 1 for [prime] no n^4
        }
        if (mults == 0) {
            std::cout << "fn_31 = " << count << std::endl;
            return count;
        }
        count += mults;
        i++;
    } while(1);
}

int64_t fn_111(int64_t n) { // p*q*r < n
    int64_t p = 2;
    int64_t q = 3;
    int64_t pi = 1;
    int64_t qi = 2;


    int64_t i = 2;
    int64_t si = 3;
    int64_t total = 0;

    int64_t th = 100;

    while(primecount::pi(n / (p*q)) - i > 0) {
        while(primecount::pi(n / (p*q)) - i > 0) {
            if (p!=q) {
                total += (primecount::pi(n/(p*q)) - i);
            }
            qi++;
            q = primecount::nth_prime(qi);
            i++;
        }
        pi++;
        qi = pi+1;
        p = primecount::nth_prime(pi);
        q = primecount::nth_prime(qi);
        i = si;
        si++;
        if (p > th) {
            th += 100;
            std::cout << "(p, q) = (" <<p <<", "<<q<<")"<<std::endl;
        }
    }
    std::cout << "fn_111 = " << total << std::endl;
    return total;
}
