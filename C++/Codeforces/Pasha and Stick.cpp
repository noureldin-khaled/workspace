#include <bits/stdc++.h>

using namespace std;

int main()
{
   int n;
   scanf("%i",&n);

   if (n%2 != 0)
   {
       printf("%i",0);
       return 0;
   }
   int ans = 0;

   if ((n/2)%2 == 0)
       ans = n/4 - 1;
   else
       ans = n/4;

   printf("%i",ans);
}
