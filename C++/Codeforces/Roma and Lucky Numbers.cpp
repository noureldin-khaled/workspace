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
   int n,k;
   scanf("%i %i",&n,&k);

   int ans = 0;
   for(int i = 0; i < n; i++)
   {
       string a;
       cin >> a;

       int counter = 0;
       for(int j = 0; j < a.length(); j++)
       {
           if (a[j] == '4' || a[j] == '7')
               counter++;
       }

       if (counter <= k)
           ans++;
   }

   printf("%i",ans);
}
