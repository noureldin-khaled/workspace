#include <bits/stdc++.h>

using namespace std;

int main()
{
   int n, m;
   scanf("%i %i",&n, &m);

   int maximum = 0;
   for(int i = 0; i < n; i++)
   {
       int cur = 1000000005;
       for(int j = 0; j < m; j++)
       {
           int val;
           scanf("%i",&val);
           cur = min(cur, val);
       }

       maximum = max(maximum,cur);
   }

   printf("%i",maximum);
}
