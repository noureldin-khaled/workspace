#include <bits/stdc++.h>

using namespace std;

int main()
{
   int a,b,c,d;
   scanf("%i %i %i %i",&a,&b,&c,&d);

   double p = (a*1.0)/b;
   double q = (1-((c*1.0)/d))*(1-((a*1.0)/b));

   printf("%.12f", p/(1-q));
}
