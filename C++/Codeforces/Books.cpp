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
   int n,t;
   scanf("%i %i",&n,&t);

   int arr[n];
   for(int i = 0; i < n; i++)
       scanf("%i",&arr[i]);

   int maxLength = 0;
   int index = 1;
   int time = 0;
   int cur = maxLength;
   if (arr[0] <= t)
   {
       maxLength++;
       index--;
       time = arr[0];
       cur++;
   }
   for(int i = 1; i < n; i++)
   {
       if (time + arr[i] <= t)
       {
           time += arr[i];
           cur++;
       }
       else
       {
           time -= arr[index];
           index++;
           cur--;
           i--;
       }

       maxLength = max(cur,maxLength);
   }
   printf("%d",maxLength);
}
