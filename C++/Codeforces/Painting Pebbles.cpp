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
   int n,k;
   scanf("%i %i",&n,&k);

   int maxE;
   scanf("%i",&maxE);
   int arr[n];
   int minE = maxE;

   arr[0] = maxE;
   for(int i = 1; i < n; i++)
   {
       int a;
       scanf("%i",&a);
       maxE = max(maxE,a);
       minE = min(minE,a);

       arr[i] = a;
   }

   if (maxE - k > minE)
       printf("NO");
   else
   {
       printf("YES\n");

       for(int i = 0; i < n; i++)
       {
           int count = 1;
           for(int j = 0; j < arr[i]; j++)
           {
               if (count > k) count = 1;
               printf("%i ",count);
               count++;
           }
           printf("\n");
       }
   }
}
