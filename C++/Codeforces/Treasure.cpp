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
   string line;
   cin >> line;

   vector<int> v;
   int index = -1;
   string temp = "";
   int len = line.length();
   for(int i = 0; i < len; i++)
   {
       if (line[i] == '#') {
           index = i;
           temp += ')';
           v.push_back(1);
       }
       else
           temp += line[i];
   }
   v.pop_back();
   int a[len];
   a[0] = 0;
   if (temp[0] == '(')
       a[0]++;
   else
       a[0]--;
   for(int i = 1; i < len; i++)
   {
       if (temp[i] == '(')
           a[i] = a[i-1] + 1;
       else
           a[i] = a[i-1] - 1;
   }

   for(int i = 0; i < len; i++)
   {
       if (a[i] < 0)
       {
           printf("%i",-1);
           return 0;
       }
   }

   string res = "";
   for(int i = 0; i < len; i++)
   {
       if (i == index)
       {
           for(int j = 0; j < a[len-1]+1; j++)
               res += ')';
           v.push_back(a[len-1]+1);
           continue;
       }
       res += temp[i];
   }

   int c = 0;
   for(int i = 0; i < res.length(); i++)
   {
       if (c < 0)
       {
           printf("%i",-1);
           return 0;
       }
       if (res[i] == '(')
           c++;
       else
           c--;
   }
   if (c != 0)
       printf("%i",-1);
   else
   {
       for(int i = 0; i < v.size(); i++)
           printf("%i\n",v[i]);
   }
}
