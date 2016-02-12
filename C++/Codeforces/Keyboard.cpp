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
   string arr[10] = {"qwertyuiop","asdfghjkl;","zxcvbnm,./"};

   char d;
   cin >> d;
   string line;
   cin >> line;

   int shift = 1;
   if (d == 'R')
       shift *= -1;
   for(int i = 0; i < line.length();i++)
   {
       for(int j = 0; j < 3; j++)
       {
           for(int k = 0; k < 10; k++)
           {
               if (line[i] == arr[j][k])
                   printf("%c",arr[j][k+shift]);
           }
       }
   }
}
