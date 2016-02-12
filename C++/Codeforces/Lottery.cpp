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

using namespace std;

int main()
{
   int n,k;
   scanf("%i %i",&n,&k);

   int occ[k+1];
   for(int i = 0; i < k+1; i++)
       occ[i] = 0;

   for(int i = 0; i < n; i++)
   {
       int a;
       scanf("%i",&a);

       occ[a]++;
   }

   int ans = 0;
   for(int i = 1; i <= k; i++)
   {
       if (occ[i] > (n/k))
           ans += occ[i]-(n/k);
   }

   printf("%i",ans);
}
