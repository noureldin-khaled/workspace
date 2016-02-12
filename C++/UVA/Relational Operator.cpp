#include <bits/stdc++.h>

using namespace std;

int main()
{
   int t;
   scanf("%i",&t);

   while(t--)
   {
       int a, b;
       scanf("%i %i",&a, &b);

       if (a > b)
           puts(">");
       else if (a < b)
           puts("<");
       else
           puts("=");
   }
}
