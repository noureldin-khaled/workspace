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
   int n,m,d;
   scanf("%i %i %i",&n,&m,&d);

   int arr[n*m];

   int count = 0;
   for(int i = 0; i < n; i++)
   {
       for(int j = 0; j < m; j++)
       {
           int num;
           scanf("%i",&num);
           arr[count++] = num;
       }
   }

   sort(arr,arr+(n*m));
   if (n*m%2 == 0)
   {
       int mid1 = ((n*m)-1)/2;
       bool valid1 = true;
       int ans1 = 0;
       for(int i = 0; i < n*m && valid1; i++)
       {
           if (abs(arr[mid1] - arr[i])%d != 0)
               valid1 = false;
           else
               ans1 += abs(arr[mid1] - arr[i])/d;
       }

       int mid2 = ((n*m)+1)/2;
       bool valid2 = true;
       int ans2 = 0;
       for(int i = 0; i < n*m && valid2; i++)
       {
           if (abs(arr[mid2] - arr[i])%d != 0)
               valid2 = false;
           else
               ans2 += abs(arr[mid2] - arr[i])/d;
       }

       if (!valid1 && !valid2)
           printf("%i",-1);
       else if (!valid1)
           printf("%i",ans2);
       else if (!valid2)
           printf("%i",ans1);
       else
           printf("%i",min(ans1,ans2));

   }
   else
   {
       int mid = (n*m)/2;
       bool valid = true;
       int ans = 0;
       for(int i = 0; i < n*m && valid; i++)
       {
           if (abs(arr[mid] - arr[i])%d != 0)
               valid = false;
           else
               ans += abs(arr[mid] - arr[i])/d;
       }
       if (valid)
           printf("%i",ans);
       else
           printf("%i",-1);
   }
}
