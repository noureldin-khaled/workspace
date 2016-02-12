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
   long int n;
   scanf("%d",&n);

   int arr[n];
   for(int i = 0; i < n; i++)
       scanf("%i",&arr[i]);

   sort(arr,arr+n);

   long int ans = 0;
   for(int i = n-1; i >= 0; i--)
   {
       if (arr[i] == -1) continue;
       int cur = arr[i];
       for(int j = 0; j < i; j++)
       {
           if (arr[j] == -1) continue;
           if (cur + arr[j] <= 4)
           {
               cur += arr[j];
               arr[j] = -1;
           }
           else
               break;
       }
       arr[i] = -1;
       ans++;
   }

   printf("%d",ans);
}
