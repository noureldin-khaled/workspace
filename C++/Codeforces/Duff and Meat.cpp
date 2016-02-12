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
   int n;
   scanf("%i",&n);

   int minimum = 101;
   int ans = 0;
   for(int i = 0; i < n; i++)
   {
       int a,p;
       scanf("%i %i",&a,&p);

       minimum = min(minimum,p);
       ans += a*minimum;
   }
   printf("%i",ans);
   for(int i = 0; i < 10000000000; i++)
       int x = 2*2;
   cout << "dine";
}
