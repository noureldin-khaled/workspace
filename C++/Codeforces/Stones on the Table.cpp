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

   string line;
   cin >> line;

   int ans = 0;
   for(int i = 0; i < n-1; i++)
   {
       if (line[i] == line[i+1])
           ans++;
   }

   printf("%i",ans);
}
