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
   int occ[10];
   for(int i = 0; i < 10; i++)
       occ[i] = 0;

   for(int i = 0; i < 6; i++)
   {
       int c;
       scanf("%i",&c);
       occ[c]++;
   }

   bool valid = false;
   for(int i = 0; i < 10 && !valid; i++) {
       if (occ[i] >= 4)
       {
           occ[i]-=4;
           valid = true;
       }
   }

   if (!valid)
   {
       puts("Alien");
       return 0;
   }

   for(int i = 0; i < 10; i++) {
       if (occ[i] == 1)
       {
           puts("Bear");
           return 0;
       }
       if (occ[i] == 2)
       {
           puts("Elephant");
           return 0;
       }
   }


}
