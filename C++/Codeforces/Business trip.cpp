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
   int k;
   scanf("%i",&k);

   int arr[12];
   for(int i = 0; i < 12; i++)
       scanf("%i",&arr[i]);

   sort(arr,arr+12);

   int ans = 0;
   for(int i = 11; i >= 0; i--)
   {
       if (k <= 0)
       {
           printf("%i",ans);
           return 0;
       }
       k -= arr[i];
       ans++;
   }

   if (k <= 0)
   {
       printf("%i",ans);
       return 0;
   }
   printf("%i",-1);
}
