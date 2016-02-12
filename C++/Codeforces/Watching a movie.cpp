#include<iostream>
#include<string>
#include<cstring>
#include<sstream>
#include<string.h>
#include<algorithm>
#include<cmath>
#include<fstream>
#include<cstdlib>
#include<vector>
#include<stdlib.h>
#include<set>
#include<stdio.h>

using namespace std;

int main()
{
   long int n,x;
   scanf("%d %d",&n,&x);

   long int minutes = 1;
   long int watched = 0;

   pair<long int,long int> arr[n];

   for(int i = 0; i < n; i++)
   {
       long int l,r;
       scanf("%d %d",&l,&r);
       arr[i] = make_pair(l,r);
   }

   int j = 0;
   while(minutes <= arr[n-1].second)
   {
       if (minutes+x <= arr[j].first)
           minutes += x;
       else
       {
           watched += arr[j].second-minutes+1;
           minutes = arr[j].second+1;
           j++;
       }
   }

   printf("%d",watched);
}
