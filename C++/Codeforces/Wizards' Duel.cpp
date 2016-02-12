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
   int l,p,q;
   scanf("%i",&l);
   scanf("%i",&p);
   scanf("%i",&q);

   double ans = ((l*1.0)/(p+q))*p;
   printf("%.4f",ans);
}
