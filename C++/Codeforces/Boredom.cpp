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

using namespace std;

int main()
{
   int n;
   scanf("%i",&n);

   int occ[100001];
   memset(occ,0,sizeof occ);

   for(int i = 0; i < n; i++)
   {
       int a;
       scanf("%i",&a);
       occ[a]++;
   }

   long long f[100001];
   f[0] = 0;
   f[1] = occ[1];

   for(long long i = 2; i <= 100001; i++)
       f[i] = max(f[i-1],f[i-2] + occ[i]*i);

   printf("%I64d",f[100000]);
}
