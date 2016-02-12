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

   int ans = 0;
   int min;
   scanf("%i",&min);
   int max = min;

   for(int i = 1; i < n; i++)
   {
       int a;
       scanf("%i",&a);
       if (a < min)
       {
           min = a;
           ans++;
       }
       if (a > max)
       {
           max = a;
           ans++;
       }
   }

   printf("%i",ans);
}
