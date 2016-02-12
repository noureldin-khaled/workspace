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
   int i,j;

   while(scanf("%d %d",&i,&j) != EOF)
   {
       printf("%i %i ",i,j);

       if (i > j)
       {
           int temp = i;
           i = j;
           j = temp;
       }
       int maximum = 0;
       for(; i <= j; i++)
       {
           int cur = 1;
           int n = i;
           while(n != 1)
           {
               if (n%2 == 0) n /= 2;
               else
                   n = 3*n + 1;
               cur++;
           }
           maximum = max(maximum,cur);
       }
       printf("%i\n",maximum);
   }
}
