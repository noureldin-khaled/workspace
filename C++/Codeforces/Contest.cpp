#include<iostream>
#include<string>
#include<cstring>
#include<sstream>
#include<string.h>
#include<algorithm>
#include<cmath>
#include<fstream>
#include<cstdlib>
#include<vector>
#include<stdlib.h>
#include<set>
#include<stdio.h>

using namespace std;

int main()
{
   int a,b,c,d;
   scanf("%i %i %i %i",&a,&b,&c,&d);

   int misha = a-(a/250)*c;
   if ((3*a)/10 > misha)
       misha = (3*a)/10;

   int vasya = b-(b/250)*d;
   if ((3*b)/10 > vasya)
       vasya = (3*b)/10;

   if (vasya > misha)
       printf("%s","Vasya");
   else if (misha > vasya)
       printf("%s","Misha");
   else
       printf("%s","Tie");
}
