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
   int n;
   scanf("%i",&n);

   int up[n];
   int down[n];
   int cross[n];
   up[0] = 0;
   down[n-1] = 0;

   for(int i = 1; i < n; i++)
   {
       int num;
       scanf("%i",&num);

       up[i] = num+up[i-1];
   }

   for(int i = 0; i < n-1; i++)
       scanf("%i",&down[i]);

   for(int i = n-2; i >= 0; i--)
       down[i] += down[i+1];

   for(int i = 0; i < n; i++)
       scanf("%i",&cross[i]);

   int res[n];

   for(int i = 0; i < n; i++)
       res[i] = down[i]+cross[i]+up[i];

   sort(res,res+n);

   printf("%i",res[0]+res[1]);

}
