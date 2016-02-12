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

   int total = 0;
   for(int i = 0; i < n; i++)
   {
       int p;
       scanf("%i",&p);
       total+=p;
   }
   double ans = (total*1.0)/n;

   printf("%.12f",ans);
}
