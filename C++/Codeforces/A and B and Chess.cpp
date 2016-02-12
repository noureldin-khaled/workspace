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
   int white = 0;
   int black = 0;

   for(int i = 0; i < 8; i++)
   {
       string line;
       cin >> line;
       for(int j = 0; j < 8; j++)
       {
           char c = line[j];
           if (c == 'Q')
               white += 9;
           if (c == 'R')
               white += 5;
           if (c == 'B')
               white += 3;
           if (c == 'N')
               white += 3;
           if (c == 'P')
               white += 1;

           if (c == 'q')
               black += 9;
           if (c == 'r')
               black += 5;
           if (c == 'b')
               black += 3;
           if (c == 'n')
               black += 3;
           if (c == 'p')
               black += 1;
       }
   }

   if (white > black)
       puts("White");
   else if (black > white)
       puts("Black");
   else
       puts("Draw");
}
