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

   int x = 0;
   for(int i = 0; i < n; i++)
   {
       string line;
       cin >> line;

       for(int j = 0; j < line.length(); j++)
       {
           if (line[j] == '+') {
               x++;
               break;
           }
           else if (line[j] == '-') {
               x--;
               break;
           }
       }
   }

   printf("%i",x);
}
