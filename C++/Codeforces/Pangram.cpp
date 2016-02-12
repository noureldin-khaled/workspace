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

using namespace std;

int main()
{
   int n;
   scanf("%i",&n);

   if (n < 26)
   {
       puts("NO");
       return 0;
   }
   bool arr[26];
   string s;
   cin >> s;

   for(int i = 0; i < 26; i++)
       arr[i] = false;

   for(int i = 0; i < n; i++)
       arr[tolower(s[i])-'a'] = true;

   for(int i = 0; i < 26; i++)
       if (!arr[i])
       {
           puts("NO");
           return 0;
       }

   puts("YES");
}
