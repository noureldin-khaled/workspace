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

   int start = false;
   int maximum = -1;
   int cur = maximum;
   int countOnes = 0;
   for(int i = 0; i < n; i++)
   {
       int a;
       scanf("%i",&a);

       if (!start)
       {
           if (a == 0) {
               start = true;
               cur = 1;
           }
       }
       else
       {
           if (a == 0)
               cur++;
           else
               cur--;
           if (cur < 0)
               start = false;
       }
       maximum = max(maximum,cur);
       if (a == 1) countOnes++;
   }
   printf("%i",maximum+countOnes);
}
