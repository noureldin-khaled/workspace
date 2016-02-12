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

   long int first;
   scanf("%d",&first);
   long int prev = first;
   long int i = 1;
   bool stop = false;
   for(; i < n & !stop; i++)
   {
       long int a;
       scanf("%d",&a);
       if (a < prev)
           stop = true;
       prev = a;
   }

   if (!stop)
       printf("%i",0);
   else {
       long int ans = 1;
       for(; i < n; i++)
       {
           long int a;
           scanf("%d",&a);
           if (a < prev)
           {
               printf("%i",-1);
               return 0;
           }
           ans++;
           prev = a;
       }

       if (prev > first)
           printf("%i",-1);
       else
           printf("%d",ans);
       }
}
