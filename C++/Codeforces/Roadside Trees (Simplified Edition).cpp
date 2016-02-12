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

   long int ans = 0;
   int prev;
   scanf("%d",&prev);
   ans += prev+1;

   for(long int i = 1; i < n; i++)
   {
       int h;
       scanf("%d",&h);
       ans += abs(h-prev)+2;
       prev = h;
   }

   printf("%d",ans);
}
