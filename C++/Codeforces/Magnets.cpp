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

   string prev;
   cin >> prev;

   long int ans = 1;
   for(long int i = 1; i < n; i++)
   {
       string s;
       cin >> s;

       if (s.compare(prev) != 0)
           ans++;
       prev = s;
   }

   printf("%d",ans);
}
