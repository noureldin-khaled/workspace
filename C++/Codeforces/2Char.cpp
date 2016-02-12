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


bool contains(string s,char c)
{
   for(int i = 0; i < s.length(); i++)
       if (s[i] == c)
           return true;

   return false;
}

int main()
{
   int n;
   scanf("%i",&n);

   pair<pair<char,int> ,pair<char,int> > arr[n];

   for(int i = 0; i < n; i++)
   {
       string line;
       cin >> line;

       string temp = "";
       int linelen = line.length();
       for(int j = 0; j < linelen; j++)
       {
           if (!contains(temp,line[j]))
               temp += line[j];
       }

       int len = temp.length();
       if (len > 2)
           arr[i] = make_pair(make_pair('1',0),make_pair('1',0));
       else if (len == 1)
           arr[i] = make_pair(make_pair(temp[0], linelen),make_pair('1',0));
       else if (len == 2)
       {
           int countFirst = 0;
           int countSecond = 0;
           char first = temp[0];
           char second = temp[1];
           for(int j = 0; j < linelen; j++)
           {
               if (line[j] == first)
                   countFirst++;
               else
                   countSecond++;
           }
           arr[i] = make_pair(make_pair(first,countFirst),make_pair(second,countSecond));
       }
   }
   int occ[26];
   memset(occ,0,sizeof occ);

   for(int i = 0; i < n; i++)
   {
       if (arr[i].first.first != '1' && arr[i].second.first == '1')
       occ[arr[i].first.first - 'a'] += arr[i].first.second;
   }

   sort(occ,occ+26);
   reverse(occ,occ+26);
   int maximum = occ[0] + occ[1];

   for(int i = 0; i < n; i++)
   {
       if (arr[i].first.first == '1' || arr[i].second.first == '1')
           continue;
       else
       {
           int cur = arr[i].first.second + arr[i].second.second;
           for(int j = 0; j < n; j++)
           {
               if (i == j)
                   continue;
               if ((arr[j].first.first == arr[i].first.first && arr[j].second.first == arr[i].second.first) ||
                   (arr[j].first.first == arr[i].second.first && arr[j].second.first == arr[i].first.first) ||
                   arr[j].first.first == arr[i].first.first && arr[j].second.first == '1' ||
                   arr[j].first.first == arr[i].second.first && arr[j].second.first == '1')
                   cur += arr[j].first.second + arr[j].second.second;
           }
           maximum = max(maximum,cur);
       }
   }
   printf("%i",maximum);
}
