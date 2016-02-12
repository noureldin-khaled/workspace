#include <bits/stdc++.h>

using namespace std;

int main()
{
   int d, l, v1, v2;
   scanf("%i %i %i %i",&d, &l, &v1, &v2);

   double d2 = (double)(l-d)/(((double)v1 / v2) + 1);
   double d1 = ((double)v1/v2) * d2;

   double t1 = d1/v1;
   double t2 = d2/v2;

   double t = min(t1, t2);
   printf("%.6f",t);
}
