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
   int months[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
   while(true)
   {
       int g,d,m,y;
       scanf("%d %d %d %d",&g,&d,&m,&y);
       if (g == 0 && d == 0 && m == 0 && y == 0)
           break;

       while(g >= 365)
       {
           g -= 365;
           if ((y%4 == 0 && y%100 != 0) || y%400 == 0) // leap year
               g--;
           y++;
       }
       if (((y%4 == 0 && y%100 != 0) || y%400 == 0) && m > 2) // leap year
               g--;

       int days = months[m-1];
       if (((y%4 == 0 && y%100 != 0) || y%400 == 0) && m == 2)
               days++;
       while(g > 0)
       {
           d++;
           g--;
           if (d > days) {
               d = 1;
               m++;
               if (m > 12) {
                   m = 1;
                   y++;
               }
               days = months[m-1];
               if (((y%4 == 0 && y%100 != 0) || y%400 == 0) && m == 2)
                   days++;
           }
       }

       printf("%d %d %d\n",d,m,y);
   }

}
