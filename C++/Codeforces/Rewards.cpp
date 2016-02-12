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
   int a1,a2,a3,b1,b2,b3,n;
   scanf("%i %i %i",&a1,&a2,&a3);
   scanf("%i %i %i",&b1,&b2,&b3);
   scanf("%i",&n);

   int cups = a1+a2+a3;
   int medals = b1+b2+b3;

   n -= cups/5;
   if (cups%5 != 0)
       n--;
   n -= medals/10;
   if (medals%10 != 0)
       n--;

   if (n<0)
       puts("NO");
   else
       puts("YES");
}
