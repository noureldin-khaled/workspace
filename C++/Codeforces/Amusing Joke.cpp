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
   string s1,s2,s3;
   cin >> s1;
   cin >> s2;
   cin >> s3;

   int length = s3.length();
   for(int i = 0; i < length; i++)
       for(int j = 0; j < s1.length(); j++)
       {
           if (s1[j] == '1') continue;
           if (s3[i] == s1[j])
           {
               s3[i] = s1[j] = '1';
               break;
           }
       }

   for(int i = 0; i < length; i++) {
       if (s3[i] == '1') continue;
       for(int j = 0; j < s2.length(); j++)
       {
           if (s2[j] == '1') continue;
           if (s3[i] == s2[j])
           {
               s3[i] = s2[j] = '1';
               break;
           }
       }
   }

   for(int i = 0; i < s1.length(); i++)
       if (s1[i] != '1')
       {
           puts("NO");
           return 0;
       }

   for(int i = 0; i < s2.length(); i++)
       if (s2[i] != '1')
       {
           puts("NO");
           return 0;
       }

   for(int i = 0; i < length; i++)
       if (s3[i] != '1')
       {
           puts("NO");
           return 0;
       }

   puts("YES");
}
