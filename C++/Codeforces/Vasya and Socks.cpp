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
   int n,m;
   scanf("%i %i",&n,&m);

   int days = 0;
   int t = 0;
   while(true)
   {
       if (t == m)
       {
           n++;
           t = 0;
       }
       if (n == 0)
           break;
       days++;
       t++;
       n--;
   }

   printf("%i",days);
}
