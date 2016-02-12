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

   bool arr[1000001];
   for(int k = 0; k <= 1000000; k++)
       arr[k] = false;
   arr[0] = arr[1] = true;

   for(long int i = 2; i*i <= 1000000; i++)
   {
       if (!arr[i])
       {
           for(long int j = i*i; j <= 1000000; j += i)
               arr[j] = true;
       }
   }

   long int n;
   scanf("%d",&n);

   for(long int i = 0; i < n; i++)
   {
       long long x;
       scanf("%I64d",&x);
       long long sq = sqrt(x);
       if (sq*sq != x) {
           puts("NO");
           continue;
       }
       if (!arr[sq])
           puts("YES");
       else
           puts("NO");
   }
}
