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
   int d,sumTime;
   scanf("%i %i",&d,&sumTime);

   pair<int,int> arr[d];
   int res[d];

   int sum = 0;
   for(int i = 0; i < d; i++)
   {
       int minTime,maxTime;
       scanf("%i %i",&minTime,&maxTime);

       arr[i] = make_pair(minTime,maxTime);
       res[i] = minTime;
       sum += minTime;
   }

   if (sum > sumTime)
       puts("NO");
   else
   {
       bool found = false;
       for(int i = 0; i < d && !found; i++)
       {
           sum += (arr[i].second-arr[i].first);

           if (sum < sumTime)
               res[i] += (arr[i].second-arr[i].first);
           if (sum > sumTime)
           {
               res[i] += (arr[i].second-arr[i].first)-(sum-sumTime);
               sum = sumTime;
               if (sum == sumTime)
               {
                   found = true;
                   continue;
               }
           }
           if (sum == sumTime)
           {
               res[i] += (arr[i].second-arr[i].first);
               found = true;
               continue;
           }
       }

       if (!found)
           puts("NO");
       else
       {
           puts("YES");
           for(int i = 0; i < d; i++)
               printf("%i ",res[i]);
       }
   }
}
