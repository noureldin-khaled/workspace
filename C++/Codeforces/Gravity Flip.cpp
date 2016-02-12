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

   int maximum = 0;
   int arr[n];
   for(int i = 0; i < n; i++)
   {
       int a;
       scanf("%i",&a);
       maximum = max(maximum,a);
       arr[i] = a;
   }

   int box[maximum][n];
   for(int i = 0; i < maximum; i++)
       for(int j = 0; j < n; j++)
           box[i][j] = 0;

   for(int i = 0; i < n; i++)
   {
       for(int j = 0; j < arr[i]; j++)
           box[j][i] = 1;
   }

   for(int i = 0; i < maximum; i++)
   {
       for(int j = n-1; j >= 0; j--)
       {
           if (box[i][j] == 0)
           {
               for(int k = j-1; k >= 0; k--)
               {
                   if (box[i][k] == 1)
                   {
                       box[i][k] = 0;
                       box[i][j] = 1;
                       break;
                   }
               }
           }
       }
   }
   int res[n];
   for(int j = 0; j < n; j++) {
       int count = 0;
       for(int i = 0; i < maximum; i++) {
           count += box[i][j];
       }
   res[j] = count;
   }

   for(int i = 0; i < n; i++)
       printf("%i ",res[i]);
}
