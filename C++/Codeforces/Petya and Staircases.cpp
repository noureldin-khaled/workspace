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
   int n,m;
   scanf("%i %i",&n,&m);

   int arr[m];
   for(int i = 0; i < m; i++)
       scanf("%i",&arr[i]);

   sort(arr,arr+m);

   if (arr[0] == 1 || arr[m-1] == n)
   {
       puts("NO");
       return 0;
   }

   for(int i = 0; i < m-2; i++)
   {
       if (arr[i]+2 == arr[i+2] && arr[i+1]+1 == arr[i+2])
       {
           puts("NO");
           return 0;
       }
   }

   puts("YES");
}
