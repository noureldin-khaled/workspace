#include <bits/stdc++.h>

using namespace std;

int main()
{
   int n, p;
   scanf("%i %i",&n, &p);

   int divisors[n];
   pair<int, int> ranges[n];
   for (int i = 0; i < n; i++)
   {
       int l, r;
       scanf("%i %i",&l, &r);

       ranges[i] = make_pair(l, r);
       int d1 = r/p;
       int d2 = l/p;
       divisors[i] = d1-d2;
       if (l%p == 0)
           divisors[i]++;
   }

   double ans = 0;
   for (int i = 0; i < n-1; i++)
   {
       double p1 = (double)divisors[i] / (ranges[i].second - ranges[i].first + 1);
       double p2 = (double)divisors[i+1] / (ranges[i+1].second - ranges[i+1].first + 1);
       ans += p1 + p2 - p1*p2;
   }

   double p1 = (double)divisors[0] / (ranges[0].second - ranges[0].first + 1);
   double p2 = (double)divisors[n-1] / (ranges[n-1].second - ranges[n-1].first + 1);

   ans += p1 + p2 - p1*p2;
   printf("%.6f\n",ans*2000);
}
