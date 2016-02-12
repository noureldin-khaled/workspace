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

   int arr[n];
   for(int i = 0; i < n; i++)
       scanf("%i",&arr[i]);

   int minimum = 100000001;
   int minIndex = -1;
   for(int i = 0; i < k; i++)
   {
       int cur = 0;
       for(int j = i; j < n; j+=k)
           cur += arr[j];

       if (cur < minimum)
       {
           minimum = cur;
           minIndex = i+1;
       }
   }
   printf("%i",minIndex);
}
