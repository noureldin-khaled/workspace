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

   int sumA = 0;
   int sumG = 0;
   string res = "";
   for(int i = 0; i < n; i++)
   {
       int a,g;
       scanf("%i %i",&a,&g);

       if (sumA != sumG)
       {
           if (abs((sumG+g)-sumA) < abs((sumA+a)-sumG))
           {
               sumG += g;
               res += 'G';
           }
           else
           {
               sumA += a;
               res += 'A';
           }
       }
       else
       {
           if (a < g) {
               sumA += a;
               res += 'A';
           }
           else {
               sumG += g;
               res += 'G';
           }
       }
   }
   if (abs(sumA-sumG) > 500)
       printf("%i",-1);
   else
       cout << res << endl;
}
