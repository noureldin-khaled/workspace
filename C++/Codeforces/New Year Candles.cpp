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
   int a,b;
   scanf("%i %i",&a,&b);

   int hours = a;
   while(true)
   {
       if (a < b)
           break;
       hours += a/b;
       a = a/b + a%b;
   }
   printf("%i",hours);
}
