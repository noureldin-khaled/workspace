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

   pair<int,int> arr[n];
   for(int i = 0; i < n; i++)
   {
       int h,m;
       scanf("%d %d",&h,&m);

       arr[i] = make_pair(h,m);
   }

   sort(arr,arr+n);

   int maximum = 1;
   int cur = maximum;
   for(int i = 0; i < n-1; i++)
   {
       if (arr[i].first == arr[i+1].first && arr[i].second == arr[i+1].second)
           cur++;
       else
           cur = 1;

       maximum = max(maximum, cur);
   }

   printf("%i",maximum);
}
