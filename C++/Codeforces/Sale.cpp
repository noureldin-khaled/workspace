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

   vector<int> v;
   for(int i = 0; i < n; i++)
   {
       int a;
       scanf("%i",&a);
       if (a < 0)
           v.push_back(a);
   }

   sort(v.begin(),v.end());

   int ans = 0;
   for(int i = 0; i < v.size() && m > 0; i++,m--)
       ans += v[i]*-1;
   printf("%i",ans);
}
