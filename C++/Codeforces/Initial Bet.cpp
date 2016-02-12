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
   int c1,c2,c3,c4,c5;
   scanf("%i %i %i %i %i",&c1,&c2,&c3,&c4,&c5);

   int sum = c1 + c2 + c3 + c4 + c5;
   if (sum%5 != 0 || sum < 5)
       printf("%i",-1);
   else
       printf("%i",sum/5);
}
