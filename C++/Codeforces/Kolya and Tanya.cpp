#include<iostream>
#include<string>
#include<cstring>
#include<sstream>
#include<string.h>
#include<algorithm>
#include<cmath>
#include<cstdlib>
#include<vector>
#include<stdlib.h>
#include<set>
#include<stdio.h>
#define toInt(x) {atoi(x.c_str())};
#define MOD 1000000007

using namespace std;

long long power(int base,int p)
{
   if (p == 0)
       return 1;
   return ((base*power(base,p-1))%MOD + MOD)%MOD;
}

int main()
{
   int n;
   scanf("%i",&n);

   long long ans = ((((power(27,n))%MOD+MOD)%MOD - ((power(7,n))%MOD+MOD)%MOD)%MOD+MOD)%MOD;
   printf("%I64d", ans);
}
