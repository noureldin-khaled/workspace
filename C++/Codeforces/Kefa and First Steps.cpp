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
   long int n;
   scanf("%d",&n);

   long int prev;
   scanf("%d",&prev);

   long int i = 1;
   long int maximum = 1;
   long int cur = 1;
   bool changed = false;
   for(; i < n; i++)
   {
       long int a;
       scanf("%d",&a);

       if (a >= prev)
           cur++;
       else
       {
           if (cur > maximum)
               maximum = cur;
           cur = 1;
       }
       prev = a;
   }
   if (cur > maximum)
       maximum = cur;

   printf("%d",maximum);
}
