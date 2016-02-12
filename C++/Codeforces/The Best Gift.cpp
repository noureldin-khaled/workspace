#include <bits/stdc++.h>

using namespace std;

int main()
{
   int n, m;
   scanf("%i %i",&n, &m);

   int occ[m+1];
   memset(occ, 0, sizeof occ);
   for(int i = 0; i < n; i++)
   {
       int a;
       scanf("%i",&a);
       occ[a]++;
   }

   int ans = 0;
   for(int i = 1; i <= m; i++)
   {
       int sum = 0;
       if (occ[i] > 0)
       {
           for(int j = i+1; j <= m; j++)
               sum += occ[j];
           sum *= occ[i];
       }
       ans += sum;
   }

   printf("%i",ans);
}
