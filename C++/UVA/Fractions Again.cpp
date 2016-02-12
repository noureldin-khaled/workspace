#include<iostream>
#include<string>
#include<cstring>
#include<sstream>
#include<string.h>
#include<string>
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
   int k;
   while(cin >> k)
   {
       int count = 1;
       int size = 0;
       string out = "";
       for(int y = k+1; y <= k*2; y++)
       {
           if((k*y) % count == 0)
           {
               int x = (k*y)/count;
               size++;
               out += "1/" + SSTR(k) + " = 1/" + SSTR(x) + " + 1/" + SSTR(y) + "\n";
           }
           count++;
       }
       printf("%d\n",size);
       cout << out;

   }
}
