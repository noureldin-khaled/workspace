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

   string s1;
   string s2;

   cin >> s1;
   cin >> s2;

   int ans = 0;
   for(int i = 0; i < n; i++)
   {
       int a = s1[i]-'0';
       int b = s2[i]-'0';

       if (a > b)
           ans += min(a-b,9-a+1+b);
       else
           ans += min(b-a,a+1+(9-b));
   }

   printf("%i",ans);
}
