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
   long int n,s,t;
   scanf("%d %d %d",&n,&s,&t);

   long int arr[n];

   for(long int i = 0; i < n; i++)
   {
       long int a;
       scanf("%d",&a);
       arr[i] = a-1;
   }

   set<long int> visited;
   long int ans = 0;
   s--;
   t--;
   while(true)
   {
       if (s == t)
           break;
       if (visited.find(s) == visited.end()) // did not find
       {
           visited.insert(s);
           s = arr[s];
           ans++;
       }
       else
       {
           printf("%i",-1);
           return 0;
       }
   }

   printf("%d",ans);
}
