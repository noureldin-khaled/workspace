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
   string res = "";
   bool flag = false;
   while(getline(cin,s))
   {
       for(int i = 0; i < s.length(); i++)
       {
           if (s[i] == '"')
           {
               if (!flag)
               {
                   res +=  "``";
                   flag = true;
               }
               else
               {
                   res +=  "''";
                   flag = false;
               }
           }
           else
               res += s[i];
       }
       res += '\n';
   }
   cout << res;
}
