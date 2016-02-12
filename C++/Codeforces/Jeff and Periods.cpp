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
   int n;
   scanf("%i",&n);

   int diff[100001];
   int lastSeen[100001];
   memset(diff,0,sizeof diff);
   memset(lastSeen,-1,sizeof lastSeen);

   for(int i = 0; i < n; i++)
   {
       int a;
       scanf("%i",&a);

       if (lastSeen[a] == -1)
       {
           lastSeen[a] = i;
           continue;
       }

       if (diff[a] == -1)
           continue;
       int newdiff = i-lastSeen[a];
       if (diff[a] == 0)
           diff[a] = newdiff;
       else if (diff[a] != newdiff) {
           diff[a] = -1;
           continue;
       }
       lastSeen[a] = i;
   }

   string res = "";
   int count = 0;
   for(int i = 1; i < 100001; i++)
   {
       if (diff[i] != -1 && lastSeen[i] != -1)
       {
           count++;
           res += SSTR(i) + " " + SSTR(diff[i]) + '\n';
       }
   }
   printf("%i\n",count);
   cout << res << endl;
}
