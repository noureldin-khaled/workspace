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
   int n;
   scanf("%i",&n);

   if (n == 1)
   {
       printf("%i",1);
       return 0;
   }
   int maximum = 2;
   int cur = maximum;
   int prev1;
   int prev2;

   scanf("%i %i",&prev1,&prev2);

   for(int i = 2; i < n; i++)
   {
       int a;
       scanf("%i",&a);

       if (a == prev1+prev2)
           cur++;
       else
           cur = 2;

       maximum = max(maximum,cur);
       prev1 = prev2;
       prev2 = a;
   }

   printf("%i",maximum);
}
