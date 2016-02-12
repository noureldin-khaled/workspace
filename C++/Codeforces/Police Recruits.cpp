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

   int police = 0;
   int ans = 0;

   for(int i = 0; i < n; i++)
   {
       int a;
       scanf("%i",&a);
       if (a == -1)
       {
           if (police > 0)
               police--;
           else
               ans++;
       }
       else
           police += a;
   }
   printf("%i",ans);
}
