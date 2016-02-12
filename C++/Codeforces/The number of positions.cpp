#include <bits/stdc++.h>

using namespace std;

int main()
{
   int n, a, b;
   scanf("%i %i %i",&n, &a, &b);

   int ans = 0;
   for(int i = 0; i <= b; i++)
   {
       int num = (n-1) - i;
       if (num >= a && num < n)
           ans++;
   }

   printf("%i",ans);
}
