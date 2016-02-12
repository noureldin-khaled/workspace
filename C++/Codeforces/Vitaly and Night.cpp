#include <bits/stdc++.h>

using namespace std;

int main()
{
   int n,m;
   scanf("%i %i",&n,&m);

   int ans = 0;
   for(int i = 0; i < n; i++)
   {
       for(int j = 0; j < m; j++)
       {
           int a,b;
           scanf("%i %i",&a,&b);

           if (a || b)
               ans++;
       }
   }
   printf("%i",ans);
}
