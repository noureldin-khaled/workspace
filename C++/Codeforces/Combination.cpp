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

   pair<int,int> arr[n];
   for(int i = 0; i < n; i++)
   {
       int a,b;
       scanf("%i %i",&a,&b);

       arr[i] = make_pair(b,a);
   }

   sort(arr,arr+n);
   reverse(arr,arr+n);

   int score = 0;
   int turn = 1;
   for(int i = 0; i < n; i++)
   {
       if (turn == 0)
           break;
       score += arr[i].second;

       turn--;
       turn+=arr[i].first;
   }

   printf("%i",score);
}
