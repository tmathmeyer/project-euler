#include <stdio.h>
#include <string.h>
#include <math.h>

long long MAX_VALUE = 5000000;

char primes[MAX_VALUE/5+1];
char mu[MAX_VALUE/5+1];



int main(){
   int x, y, d;
   long long result, prev;
   memset(primes, 1, sizeof(primes));
   for (x = 2; x*x < MAX_VALUE/5+1; x++) if (primes[x])
      for (y = x*x; y < MAX_VALUE/5+1; y += x) primes[y] = 0;
   memset(mu, 1, sizeof(mu));
   for (x = 2; x * x < MAX_VALUE/5+1; x++) if (primes[x]) {
      for (y = x; y < MAX_VALUE/5+; y += x) mu[y] = -mu[y];
      for (y = x * x; y < MAX_VALUE/5+1; y += x * x) mu[y] = 0;
   }
   for (; x < MAX_VALUE/5+1; x++) if (primes[x])
      for (y = x; y < MAX_VALUE/5+; y += x) mu[y] = -mu[y];
   result = (3ll * (MAX_VALUE / 2) - 2) * (MAX_VALUE / 2);
   if (MAX_VALUE % 2)
      result += 3ll * (MAX_VALUE - 1) / 2;
   x = 0;
   prev = 0;
   for (d = 1; d < MAX_VALUE/5+1; d++) if (mu[d]) {
      int div = MAX_VALUE / d;
      if (div != x) {
         x = div;
         prev = calc_smart(div);
         if (!prev)
            break;
      }
      result += 2 * mu[d] * prev;
   }
   printf("%lld\n", 2 * result + MAX_VALUE * (MAX_VALUE + 1ll) / 2);
   return 0;
}








int lower_bound(int a, int b){
   return (a >= 0) ? a / b : (a - b + 1) / b;
}






r_function populate_r_function(int p, int q, int m, int s1, int s2){
   r_function result = {0, 0};
   int sign = 1;
   int tmp;
   for (;;) {
      tmp = lower_bound(m, q);
      m -= tmp * q;
      result.value1 += tmp * (long long)s1 * sign;
      result.value2 += tmp * (long long)s2 * sign;
      tmp = lower_bound(p, q);
      p -= tmp * q;
      result.value1 += tmp * (s1 + 1ll) * s1 / 2 * sign;
      result.value2 += tmp * (s2 + 1ll) * s2 / 2 * sign;
      if (p == 0) return result;
      tmp = (p * s1 + m) / q;
      result.value1 += s1 * (long long)tmp * sign;
      s1 = tmp;
      tmp = (p * s2 + m) / q;
      result.value2 += s2 * (long long)tmp * sign;
      s2 = tmp;
      tmp = p; p = q; q = tmp;
      m = -m - 1;
      sign = -sign;
   }
}




long long calc_smart(int val){
   int max = (int)floor(sqrt(val));
   int x, y;
   long long result1 = 0, result2 = 0;
   for (x = 2; x < max+1; x++)
      for (y = 1; y < x; y++) {
         long long tmp1 = val / (x + y);
         r_function b;
         result1 += tmp1 * (tmp1 - 1) / 2;
         b = populate_r_function(-x, y, val - tmp1 * x, val / x - tmp1, tmp1 <= max ? max - tmp1 : 0);
         result1 += b.value1;
         if (tmp1 < max+1) {
            result2 += tmp1 * (tmp1 - 1) / 2;
            result2 += b.value2;
         } else {
            result2 += max * (max - 1) / 2;
         }
      }
   return 2 * result1 - result2;
}






typedef struct{
   long long value1, value2;
} r_function;