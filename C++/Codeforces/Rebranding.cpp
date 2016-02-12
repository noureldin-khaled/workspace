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
   int n,m;
   scanf("%i %i",&n,&m);

   char s[n];
   scanf("%s",&s);

   char arr[26];
   memset(arr,'*',sizeof arr);

   while(m--)
   {
       char x,y;
       cin >> x >> y;

       int index = x - 'a';
       char temp = ' ';
       while(true)
       {
           if (arr[index] == '*' || arr[index] == x)
           {
               temp = arr[index];
               arr[index] = y;
               break;
           }
           index = arr[index] - 'a';
       }

       arr[index] = temp;
       int index2 = y - 'a';
       while(true)
       {
           if (arr[index2] == '*' || arr[index2] == y)
           {
               arr[index2] = x;
               break;
           }
           index2 = arr[index2] - 'a';
       }
       arr[index] = y;
   }

   for(int i = 0; i < n; i++)
   {
       char res;
       if (arr[s[i]-'a'] != '*')
           res = arr[s[i]-'a'];
       else
           res = s[i];
       printf("%c",res);
   }
}
