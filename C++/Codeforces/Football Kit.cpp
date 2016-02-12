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

   long int occ[100005];
   for(long int i = 0; i < 100005; i++)
       occ[i] = 0;

   long int away[n];
   for(long int i = 0; i < n; i++)
   {
       long int x,y;
       scanf("%d %d",&x,&y);
       occ[x]++;
       away[i] = y;
   }

   pair<long int,long int> out[n];
   for(long int i = 0; i < n; i++)
       out[i] = make_pair(n-1,n-1);

   for(long int i = 0; i < n; i++)
   {
       long int f = occ[away[i]];
       out[i].first += f;
       out[i].second -= f;
   }

   for(long int i = 0; i < n; i++)
       printf("%d %d\n",out[i].first,out[i].second);
}
