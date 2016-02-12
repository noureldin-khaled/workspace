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
#define PI 3.1415926536

using namespace std;

int main()
{
   int n;
   scanf("%i",&n);

   int arr[n];
   for(int i = 0; i < n; i++)
       scanf("%i",&arr[i]);

   sort(arr,arr+n);
   reverse(arr,arr+n);

   int total = 0;
   for(int i = 0; i < n-1; i+= 2)
       total += (arr[i]*arr[i] - arr[i+1]*arr[i+1]);

   if (n%2 != 0)
       total += arr[n-1]*arr[n-1];

   double ans = (total*1.0)*PI;
   printf("%.10f",ans);
}
