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
   int n,m;
   scanf("%i %i",&n,&m);

   long long arr[n];
   long long arr2[m];

   for(int i = 0 ; i < n; i++)
       scanf("%I64d",&arr[i]);

   for(int i = 0 ; i < m; i++)
       scanf("%I64d",&arr2[i]);

   int ans = 0;
   for(int i = n-1; i >= 0; i--)
   {
       bool found = false;
       for(int j = m-1; j >= 0 && !found; j--)
       {
           if (arr2[j] == -1) continue;
           if (arr2[j] >= arr[i])
           {
               arr2[j] = arr[i] = -1;
               found = true;
           }
       }
       if (!found)
           ans++;
   }

   printf("%d",ans);


}
