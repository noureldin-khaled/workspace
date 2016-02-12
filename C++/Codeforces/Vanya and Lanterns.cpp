#include<iostream>
#include<string>
#include<cstring>
#include<sstream>
#include<string.h>
#include<algorithm>
#include<cmath>
#include<fstream>
#include<cstdlib>
#include<vector>
#include<stdlib.h>
#include<set>
#include<stdio.h>
#include<limits>

using namespace std;

int main()
{
   int n;
   long int l;
   scanf("%d %d",&n,&l);

   long int arr[n];

   for(int i = 0; i < n; i++)
   {
       long int a;
       scanf("%d",&a);
       arr[i] = a;
   }

   sort(arr,arr+n);

   bool first = arr[0] == 0;
   bool second = arr[n-1] == l;

   long double maximum = 0;
   for(int i = 0; i < n-1; i++)
   {
       long double cur = ((long double)(arr[i+1] - arr[i]))/2;
       if (cur > maximum)
           maximum = cur;
   }

   if (!first && arr[0] > maximum)
       maximum = arr[0];
   if (!second && (l-arr[n-1]) > maximum)
       maximum = (l-arr[n-1]);

   cout.precision(10);
   cout << fixed << maximum << endl;
}
