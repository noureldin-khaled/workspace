#include <bits/stdc++.h>

using namespace std;

int main()
{
   int n;
   while(scanf("%i",&n) != EOF)
   {
       int res = 0;
       int c = 0;
       for(int i = 0; i < 32; i++)
       {
           if (c == 8)
           {
               res = res << 8;
               c = 0;
           }
           if ((n & (1 << i)) != 0)
               res |= (1 << c);
           c++;
       }

       printf("%i converts to %i\n",n,res);
   }
}
