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
   long int n,d;
   scanf("%d %d",&n,&d);

   pair<long int,long int> arr[n];

   for(long int i = 0; i < n; i++)
   {
       long int m,s;
       scanf("%d %d",&m,&s);

       arr[i] = make_pair(m,s);
   }

   sort(arr,arr+n);
   reverse(arr,arr+n);
   long long maximum = arr[0].second;
   long long cur = maximum;
   long int index = 0;
   for(long int i = 1; i < n; i++)
   {
       if (arr[index].first-arr[i].first < d)
           cur += arr[i].second;
       else {
           cur -= arr[index].second;
           i--;
           index++;
       }

       if (cur > maximum)
           maximum = cur;

   }

   printf("%I64d",maximum);
}
