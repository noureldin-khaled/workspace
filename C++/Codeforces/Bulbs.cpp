#include <bits/stdc++.h>

using namespace std;

int main()
{
   int n, m;
   scanf("%i %i",&n, &m);

   bool bulbs[m+1];
   memset(bulbs, false, sizeof bulbs);

   for(int i = 0; i < n; i++)
   {
       int x;
       scanf("%i",&x);
       for(int j = 0; j < x; j++)
       {
           int y;
           scanf("%i",&y);
           bulbs[y] = true;
       }
   }

   for(int i = 1; i < m+1; i++)
   {
       if (!bulbs[i])
       {
           puts("NO");
           return 0;
       }
   }
   puts("YES");
}
