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
   int p,q,l,r;
   scanf("%i %i %i %i",&p,&q,&l,&r);

   pair<int,int> arr[p];
   pair<int,int> arr2[q];

   for(int i = 0; i < p; i++)
   {
       int a,b;
       scanf("%i %i",&a,&b);
       arr[i] = make_pair(a,b);
   }

   for(int i = 0; i < q; i++)
   {
       int c,d;
       scanf("%i %i",&c,&d);
       arr2[i] = make_pair(c,d);
   }

   int ans = 0;
   for(int i = l; i <= r; i++)
   {
       bool found = false;
       for(int j = 0; j < q&& !found; j++)
       {
           pair<int,int> cur = arr2[j];
           for(int k = 0; k < p&& !found; k++)
           {
               if ((cur.first+i >= arr[k].first && cur.first+i <= arr[k].second) ||
                    (cur.second+i >= arr[k].first && cur.second+i <= arr[k].second) ||
                      (cur.first+i < arr[k].first && cur.second+i > arr[k].second)) {
                       ans++;
                       found = true;
                    }
           }
       }
   }

   printf("%i",ans);
}
