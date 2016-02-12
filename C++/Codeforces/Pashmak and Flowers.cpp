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
   scanf("%d",&n);

   int minimum = 1000000001;
   int maximum = 0;

   int arr[n];
   for(int i = 0; i < n; i++)
   {
       int b;
       scanf("%d",&b);

       minimum = min(minimum,b);
       maximum = max(maximum,b);
       arr[i] = b;
   }

   long long minOcc = 0;
   long long maxOcc = 0;
   for(int i = 0; i < n; i++)
   {
       if (arr[i] == minimum)
           minOcc++;
       if (arr[i] == maximum)
           maxOcc++;
   }
   int diff = maximum-minimum;
   long long ways = maxOcc*minOcc;
   if (diff == 0)
       ways = ((minOcc-1)*minOcc)/2;

   printf("%d %I64d",diff,ways);
}
