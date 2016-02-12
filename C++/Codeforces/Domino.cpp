#include<iostream>
#include<string>
#include<cstring>
#include<sstream>
#include<string.h>
#include<algorithm>
#include<cmath>
#include<fstream>
#include<cstdlib>
#include<vector>
#include<stdlib.h>
#include<set>
#include<stdio.h>
#include <limits>

using namespace std;

int main()
{
   int n;
   scanf("%i",&n);

   pair<int,int> arr[n];
   int countRight = 0;
   int countLeft = 0;

   for(int i = 0; i < n; i++)
   {
       int x,y;
       scanf("%i %i",&x,&y);

       arr[i] = make_pair(x,y);
       if (x%2 != 0)
           countLeft++;
       if (y%2 != 0)
           countRight++;
   }

   if (countLeft%2 == 0 && countRight%2 == 0)
       printf("%i",0);
   else if ((countLeft%2 == 0 && countRight%2 != 0) || (countLeft%2 != 0 && countRight%2 == 0))
       printf("%i",-1);
   else
   {
       int ans = 0;
       for(int i = 0; i < n; i++)
       {
           if ((arr[i].first%2 == 0 && arr[i].second%2 != 0) || (arr[i].first%2 != 0 && arr[i].second%2 == 0))
           {
               int temp = arr[i].first;
               arr[i].first = arr[i].second;
               arr[i].second = temp;

               ans++;

               int sumRight = 0;
               int sumLeft = 0;
               for(int j = 0; j < n; j++)
               {
                   sumLeft += arr[j].first;
                   sumRight += arr[j].second;
               }

               if (sumLeft%2 == 0 && sumRight%2 == 0)
               {
                   printf("%i",ans);
                   return 0;
               }
           }
       }
       printf("%i",-1);
   }
}
