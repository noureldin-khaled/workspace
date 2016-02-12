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

   long int n;
   scanf("%d",&n);

   bool arr[n];
   for(long int k = 0; k < n; k++)
       arr[k] = false;

   for(long int i = 2; i*i < n; i++)
   {
       if (!arr[i])
       {
           for(long int j = i*i; j < n; j += i)
               arr[j] = true;
       }
   }

   for(long int i = 2; i <= n/2; i++)
   {
       if (arr[i] && arr[n-i])
       {
           printf("%d %d",i,n-i);
           return 0;
       }
   }
}
