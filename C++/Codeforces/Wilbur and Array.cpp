#include <bits/stdc++.h>

using namespace std;

int main()
{
   int n;
   scanf("%i",&n);

   long long ans = 0;
   int prev = 1000000001;
   for(int i = 0; i < n; i++)
   {
       int b;
       scanf("%i",&b);

       if (prev == 1000000001)
           ans += abs(b);
       else
           ans += abs(b - prev);
       prev = b;
   }

   printf("%I64d",ans);
}
