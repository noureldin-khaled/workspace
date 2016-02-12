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
   string s1,s2;
   cin >> s1;
   cin >> s2;

   for(int i = 0; i < s1.length();i++)
   {
       if (s1[i] == s2[i])
           printf("%i",0);
       else
           printf("%i",1);
   }
}
