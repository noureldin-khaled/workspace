#include<iostream>
#include<string>
#include<cstring>
#include<sstream>
#include<string.h>
#include<algorithm>
#include<cmath>
#include<fstream>
#include<cstdlib>
#include<vector>
#include<stdlib.h>
#include<set>

using namespace std;

bool isCoprime( long long x, long long y);
long long gcd( long long a, long long b);
int main()
{
   long long l,r;
   cin >> l >> r;
   for(long long i = l; i <= r-2; i++){
       for(long long j = i+1; j <= r-1; j++){
           bool first = isCoprime(i,j);
           for(long long k = j+1; k <= r; k++){
               bool second = isCoprime(j,k);
               bool third = isCoprime(i,k);
               if (first && second && !third)
               {
                   cout << i << " " << j << " " << k << endl;
                   return 0;
               }
           }
       }
   }

   cout << -1 << endl;
}

bool isCoprime( long long x, long long y){
   return (gcd(x,y) == 1);
}

long long gcd( long long a,  long long b) {
   return b == 0 ? a : gcd(b, a % b);
}
