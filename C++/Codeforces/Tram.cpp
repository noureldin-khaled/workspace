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

   long int f = 0;
   long int maximum = 0;
   for(int i = 0; i < n; i++)
   {
       int a,b;
       scanf("%i %i",&a,&b);

       f -= a;
       f += b;

       maximum = max(maximum,f);
   }

   printf("%d",maximum);
}
