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
   int m,n,t;
   while(scanf("%i %i %i",&m,&n,&t) != EOF)
   {
       int ways[t+1];
       int wasted[t+1];

       for(int i = 0; i < t+1; i++)
       {
           int choice1 = i-m;
           int choice2 = i-n;

           if (choice1 >= 0 && choice2 >= 0)
           {
               if (wasted[choice1] < wasted[choice2])
               {
                   ways[i] = ways[choice1] + 1;
                   wasted[i] = wasted[choice1];
               }
               else if (wasted[choice1] > wasted[choice2])
               {
                   ways[i] = ways[choice2] + 1;
                   wasted[i] = wasted[choice2];
               }
               else
               {
                   wasted[i] = wasted[choice1];
                   ways[i] = max(ways[choice1],ways[choice2]) + 1;
               }
           }
           else if (choice1 >= 0)
           {
               ways[i] = ways[choice1] + 1;
               wasted[i] = wasted[choice1];
           }
           else if (choice2 >= 0)
           {
               ways[i] = ways[choice2] + 1;
               wasted[i] = wasted[choice2];
           }
           else
           {
               ways[i] = 0;
               wasted[i] = i;
           }
       }

       printf("%i",ways[t]);
       if (wasted[t] > 0)
           printf(" %i",wasted[t]);
       puts("");
   }
}
