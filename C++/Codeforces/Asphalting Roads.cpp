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

   bool horizontal[n+1];
   bool vertical[n+1];
   for(int i = 1; i < n+1; i++)
   {
       horizontal[i] = false;
       vertical[i] = false;
   }
   for(int i = 1; i <= n*n; i++)
   {
       int h,v;
       scanf("%i %i",&h,&v);

       if (!horizontal[h] && !vertical[v])
       {
           printf("%i ",i);
           horizontal[h] = vertical[v] = true;
       }
   }
}
