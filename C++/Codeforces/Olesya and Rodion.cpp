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
#define SSTR( x ) dynamic_cast< std::ostringstream & >( \
       ( std::ostringstream() << std::dec << x ) ).str()

using namespace std;

int main()
{
   int n,t;
   scanf("%i %i",&n,&t);

   string ans = SSTR(t);
   int i = 1;
   if (t == 10)
       i++;
   for(; i < n; i++)
       ans += '0';

   if (ans.length() == n)
       cout << ans << endl;
   else
       printf("%i",-1);
}
