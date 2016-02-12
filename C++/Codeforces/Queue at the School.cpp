#include<iostream>
#include<string>
#include<cstring>
#include<sstream>
#include<string.h>
#include<algorithm>
#include<cmath>
#include<fstream>
#include<cstdlib>
#include<vector>
#include<stdlib.h>
#include<set>
#include<stdio.h>

using namespace std;

int main()
{
   int n,t;
   scanf("%i %i",&n,&t);

   char arr[n];
   string s;
   cin >> s;

   for(int i = 0; i < n; i++)
       arr[i] = s[i];

   for(int i = 0; i < t; i++)
   {
       for(int j = 0; j < n-1; j++)
       {
           if (arr[j] == 'B' && arr[j+1] == 'G')
           {
               arr[j] = 'G';
               arr[j+1] = 'B';
               j++;
           }
       }
   }
   for(int i = 0; i < n; i++)
       printf("%c",arr[i]);

}
