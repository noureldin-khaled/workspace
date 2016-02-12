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

   int k;
   scanf("%i",&k);

   int arr[26];
   int max = -1;
   for(int i = 0; i < 26; i++) {
       scanf("%i",&arr[i]);
       if (arr[i] > max)
           max = arr[i];
   }

   int ans = 0;
   int i = 0;
   for(; i < s.length(); i++)
       ans += (i+1)*arr[s[i]-'a'];
   while(k--) {
       ans += (i+1)*max;
       i++;
   }

   printf("%d",ans);
}
