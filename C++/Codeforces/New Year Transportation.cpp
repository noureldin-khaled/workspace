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
   long int n,t;
   scanf("%d %d",&n,&t);

   long int arr[n-1];
   for(long int i = 0; i < n-1; i++)
       scanf("%d",&arr[i]);

   t--;
   long int i = 0;
   for(; i < n-1; i+=arr[i])
   {
       if (i == t) {
           puts("YES");
           return 0;
       }
       if (i > t) {
           puts("NO");
           return 0;
       }
   }
   if (i == t)
       puts("YES");
   else
       puts("NO");
}
