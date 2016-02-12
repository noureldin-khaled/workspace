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
#include<stdio.h>
#include<limits>

using namespace std;

long long countPairs(long long num);
int main()
{
   long long n,m;
   scanf("%I64d %I64d",&n,&m);

   long long maximum = countPairs(n-(m-1));

   long long minimum = countPairs(n/m)*(m-(n%m)) + countPairs((n/m)+1)*(n%m);

   printf("%I64d %I64d",minimum,maximum);
}

long long countPairs(long long num)
{
   long long l = num-1;

   long long ans = l*l;

   if (l%2 == 0)
       ans -= (l*((long double)(l-1)/2));
   else
       ans -= (l*(l/2));

   return ans;
}
