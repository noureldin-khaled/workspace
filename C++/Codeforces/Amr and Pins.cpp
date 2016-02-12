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

long long power(long long base,int p);
int main()
{
   long int r,x1,y1,x2,y2;
   scanf("%d %d %d %d %d",&r,&x1,&y1,&x2,&y2);


   long long p = power((x2-x1),2) + power((y2-y1),2);
   double d = sqrt(p);
   long long ans = ceil(d/(2*r));

   printf("%I64d",ans);
}

long long power(long long base,int p)
{
   if (p == 0)
       return 1;
   return base*power(base,p-1);
}
