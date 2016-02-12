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
   string line;
   cin >> line;

   int occ[26];
   for(int i = 0; i < 26; i++)
       occ[i] = 0;

   for(int i = 0; i < line.length(); i++)
       occ[line[i]-'a']++;

   int odd = 0;
   for(int i = 0; i < 26; i++)
   {
       if (occ[i]%2 != 0)
           odd++;
   }

   if (odd%2 != 0 || odd == 0)
       puts("First");
   else
       puts("Second");
}
