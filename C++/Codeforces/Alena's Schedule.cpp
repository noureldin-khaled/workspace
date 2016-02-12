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
#define toInt(x) {atoi(x.c_str())};

using namespace std;

int main()
{
   int n;
   scanf("%i",&n);

   int arr[n];
   int start = -1;
   for(int i = 0; i < n; i++)
   {
       int a;
       scanf("%i",&a);
       if (start == -1 && a == 1)
           start = i;

       arr[i] = a;
   }

   if (start == -1)
   {
       printf("%i",0);
       return 0;
   }
   int ans = 0;
   for(; start < n; start++)
   {
       if (arr[start] == 1)
           ans++;
       else
       {
           if (start + 1 < n) {
               if (arr[start+1] == 1)
                   ans++;
               else {
                   int j = start+1;
                   for(; j < n && arr[j] == 0; j++);
                   start = j-1;
               }
           }
       }
   }

   printf("%i",ans);
}
