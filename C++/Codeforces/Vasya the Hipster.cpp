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

   int maximum = max(a,b);
   int minimum = min(a,b);

   printf("%i ",minimum);

   maximum -= minimum;
   minimum = 0;

   printf("%i",maximum/2);
}
