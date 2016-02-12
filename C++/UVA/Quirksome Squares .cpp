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
   int n;
   while(scanf("%i",&n) != EOF)
   {
       if (n == 2)
       {
           for(int i = 0; i <= 99; i++)
           {
               if ((i%10 + i/10)*(i%10 + i/10) == i) {
                   if (i < 10)
                       printf("0%i\n",i);
                   else
                       printf("%i\n",i);
               }
           }
       }
       else if (n == 4)
       {
           for(int i = 0; i <= 9999; i++)
           {
               int c = 0;
               if ((i%100 + i/100)*(i%100 + i/100) == i) {
                   if (i < 10)
                       c++;
                   if (i < 100)
                       c++;
                   if (i < 1000)
                       c++;
                   while(c-->0)
                       printf("0");
                   printf("%i\n",i);
               }
           }
       }
       else if (n == 6)
       {
           for(int i = 0; i <= 999999; i++)
           {
               int c = 0;
               if ((i%1000 + i/1000)*(i%1000 + i/1000) == i) {
                   if (i < 10)
                       c++;
                   if (i < 100)
                       c++;
                   if (i < 1000)
                       c++;
                   if (i < 10000)
                       c++;
                   if (i < 100000)
                       c++;
                   while(c-->0)
                       printf("0");
                   printf("%i\n",i);
               }
           }
       }
       else
       {
           for(int i = 0; i <= 99999999; i++)
           {
               int c = 0;
               if ((i%10000 + i/10000)*(i%10000 + i/10000) == i) {
                   if (i < 10)
                       c++;
                   if (i < 100)
                       c++;
                   if (i < 1000)
                       c++;
                   if (i < 10000)
                       c++;
                   if (i < 100000)
                       c++;
                   if (i < 1000000)
                       c++;
                   if (i < 10000000)
                       c++;
                   while(c-->0)
                       printf("0");
                   printf("%i\n",i);
               }
           }
       }
   }
}
