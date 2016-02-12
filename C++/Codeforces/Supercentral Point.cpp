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
   int n;
   scanf("%i",&n);

   pair<int,int> arr[n];

   for(int i = 0; i < n; i++)
   {
       int x,y;
       scanf("%i %i",&x,&y);
       arr[i] = make_pair(x,y);
   }

   int ans = 0;
   for(int i = 0; i < n; i++)
   {
       bool upper = false;
       bool lower = false;
       bool left = false;
       bool right = false;
       pair<int,int> cur = arr[i];
       for(int j = 0; j < n && (!upper || !lower || !left || !right); j++)
       {
           if (i == j)
               continue;
           if (cur.first < arr[j].first && cur.second == arr[j].second)
               right = true;
           if (cur.first > arr[j].first && cur.second == arr[j].second)
               left = true;
           if (cur.first == arr[j].first && cur.second < arr[j].second)
               upper = true;
           if (cur.first == arr[j].first && cur.second > arr[j].second)
               lower = true;
       }

       if (upper && lower && right && left)
           ans++;
   }

   printf("%i",ans);
}
