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
   string s;
   cin >> s;

   int count4 = 0;
   int count7 = 0;
   for(int i = 0; i < s.length(); i++)
   {
       if (s[i] == '4')
           count4++;
       if (s[i] == '7')
           count7++;
   }
   if (count4 == 0 && count7 == 0)
       cout << -1 << endl;
   else if (count4 >= count7)
       cout << 4 << endl;
   else if (count7 > count4)
       cout << 7 << endl;

}
