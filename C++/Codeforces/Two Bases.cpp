#include <bits/stdc++.h>

using namespace std;

long long power(int base,int p)
{
   if (p == 0)
       return 1;
   return base*power(base,p-1);
}

int main()
{
   int n,bx;
   scanf("%i %i",&n,&bx);
   int x[n];
   for(int i = 0 ;i < n; i++)
       scanf("%i",&x[i]);

   int m,by;
   scanf("%i %i",&m,&by);
   int y[m];
   for(int i = 0 ;i < m; i++)
       scanf("%i",&y[i]);

   long long numx = 0;
   int countx = 0;
   for(int i = n-1; i >= 0; i--)
   {
       if (x[i] != 0)
           numx += ((long long)x[i])*power(bx, countx);
       countx++;
   }

   long long numy = 0;
   int county = 0;
   for(int i = m-1; i >= 0; i--)
   {
       if (y[i] != 0)
           numy += ((long long)y[i])*power(by, county);
       county++;
   }

   if (numx == numy)
       puts("=");
   else if (numx > numy)
       puts(">");
   else puts("<");
}
