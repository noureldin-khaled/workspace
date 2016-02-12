#include <bits/stdc++.h>

using namespace std;

int main()
{
   int t;
   scanf("%i",&t);

   for(int i = 1; i <= t; i++)
   {
       int a, b;
       scanf("%i",&a);
       scanf("%i",&b);

       int sum = 0;
       for(; a <= b; a++)
       {
           if (a%2 == 1)
               sum += a;
       }
       printf("Case %i: %i\n",i,sum);
   }
}
