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
   char arr[8][8];
   int distW = -1;
   int distB = -1;
   for(int i = 0 ;i < 8; i++)
   {
       string line;
       cin >> line;

       for(int j = 0; j < 8; j++)
           arr[i][j] = line[j];
   }

   for(int i = 0; i < 8; i++)
   {
       for(int j = 0; j < 8; j++)
       {
           if (arr[i][j] == 'W' && distW == -1) {
               bool valid = true;
               for(int k = i-1; k >= 0 && valid; k--)
               {
                   if (arr[k][j] != '.')
                       valid = false;
               }
               if (valid)
                   distW = i;
           }
           if (arr[i][j] == 'B') {
               bool valid = true;
               for(int k = i+1; k < 8 && valid; k++)
               {
                   if (arr[k][j] != '.')
                       valid = false;
               }
               if (valid)
                   distB = 7-i;
           }

       }
   }

   if (distW <= distB)
       cout << 'A' << endl;
   else
       cout << 'B' << endl;
}
