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

   int ans = 0;
   for(int i = 0; i < n; i++)
   {
       int p,q;
       scanf("%i %i",&p,&q);

       if (q-p >= 2)
           ans++;
   }
   printf("%i",ans);
}
