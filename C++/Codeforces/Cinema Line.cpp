#include<iostream>
#include<string>
#include<cstring>
#include<sstream>
#include<string.h>
#include<algorithm>
#include<cmath>
#include<cstdlib>
#include<vector>
#include<stdlib.h>
#include<set>
#include<stdio.h>

using namespace std;

int main()
{
   int n;
   scanf("%i",&n);

   int occ[2];
   occ[0] = occ[1] = 0;
   for(int i = 0; i < n; i++)
   {
       int a;
       scanf("%i",&a);

       if (a == 25)
       {
           occ[0]++;
           continue;
       }
       if (a == 50)
       {
           if (occ[0] > 0)
           {
               occ[0]--;
               occ[1]++;
               continue;
           }
           else
           {
               puts("NO");
               return 0;
           }
       }

       if (a == 100)
       {
           if (occ[1] > 0 && occ[0] > 0)
           {
               occ[1]--;
               occ[0]--;
               continue;
           }
           else if (occ[0] > 2)
           {
               occ[0] -= 3;
               continue;
           }
           else
           {
               puts("NO");
               return 0;
           }
       }
   }

   puts("YES");
}
