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

   int length = s.length();
   int lastDigit = s[length-1]-'0';
   for(int i = 0; i < length; i++)
   {
       int digit = s[i] - '0';
       if (digit%2 == 0 && digit < lastDigit)
       {
           char tmp = s[i];
           s[i] = s[length-1];
           s[length-1] = tmp;
           cout << s << endl;
           return 0;
       }
   }

   for(int i = length-2; i >= 0; i--)
   {
       int digit = s[i] - '0';
       if (digit%2 == 0 && digit > lastDigit)
       {
           char tmp = s[i];
           s[i] = s[length-1];
           s[length-1] = tmp;
           cout << s << endl;
           return 0;
       }
   }
   cout << -1 << endl;
}
