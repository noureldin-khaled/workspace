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

using namespace std;

int main()
{
   int n,c;
   cin >> n >> c;

   int a;
   cin >> a;
   int prev = a;
   int maxDiff = -1;
   for(int i = 1; i < n ; i++){
       cin >> a;
       int diff = prev - a;

       if (diff > maxDiff)
           maxDiff = diff;
       prev = a;
   }

   if (maxDiff-c < 0)
       cout << 0 << endl;
   else
       cout << maxDiff-c << endl;
}
