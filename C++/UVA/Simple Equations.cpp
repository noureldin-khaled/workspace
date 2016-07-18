#include <bits/stdc++.h>

using namespace std;

int main()
{
   int t;
   scanf("%i",&t);

   while(t--)
   {
       int a, b, c;
       scanf("%i %i %i",&a,&b,&c);

       bool found = false;
       for(int x = -100; x <= 100 && !found; x++)
       {
           for(int y = -100; y <= 100 && !found; y++)
           {
               if (x == y) continue;
               for(int z = -100; z <= 100 && !found; z++)
               {

                   if ((x+y+z)==a && (x*y*z)==b && ((x*x) + (y*y) + (z*z))==c)
                   {
                       printf("%i %i %i\n",x,y,z);
                       found = true;
                   }
               }
           }
       }

       if (!found)
           puts("No solution.");
   }
}
