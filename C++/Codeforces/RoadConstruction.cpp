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
   int n,m;
   scanf("%i %i",&n,&m);

   bool restricted[n];
   for(int i = 0; i < n; i++)
       restricted[i] = false;

   for(int i = 0; i < m; i++)
   {
       int a,b;
       scanf("%i %i",&a,&b);
       a--;
       b--;
       restricted[a] = restricted[b] = true;
   }

   for(int i = 0; i < n; i++)
   {
       if (!restricted[i])
       {
           printf("%i\n",n-1);
           for(int j = 0; j < n; j++)
           {
               if (i == j)
                   continue;
               printf("%i %i\n",i+1,j+1);
           }
           return 0;
       }
   }
}
