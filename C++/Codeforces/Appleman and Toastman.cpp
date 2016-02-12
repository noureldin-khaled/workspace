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

   int arr[n];
   long long total = 0;
   for(int i = 0; i < n; i++)
   {
       int a;
       scanf("%i",&a);
       arr[i] = a;
       total += a;
   }

   sort(arr,arr+n);

   long long ans = total;
   for(int i = 0; i < n; i++)
   {
       if (i == n-1)
           continue;

       ans+= arr[i] + (total-arr[i]);
       total -= arr[i];
   }

   printf("%I64d",ans);
}
