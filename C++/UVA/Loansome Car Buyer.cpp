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
   while(true)
   {
       int months;
       double down,loan,dec;
       scanf("%i %lf %lf %lf",&months,&down,&loan,&dec);

       if (months < 0)
           break;
       double depreciation[months+1];
       memset(depreciation,0,sizeof depreciation);
       for(int i = 0; i < dec; i++)
       {
           int m;
           double r;
           scanf("%i %lf",&m,&r);
           depreciation[m] = r;
       }

       double cur = depreciation[0];
       for(int i = 1; i < months+1; i++)
       {
           if (depreciation[i] == 0)
               depreciation[i] = cur;
           else
               cur = depreciation[i];
       }
       double toPay = loan/months;
       double value = down+loan;
       value *= 1-depreciation[0];
       double owed = loan;
       bool done = false;
       int i = 0;
       while(owed >= value)
       {
           if (i+1 <= months)
               i++;
           owed -= toPay;
           value *= 1-depreciation[i];
       }
       if (i == 1)
           printf("%i month\n",1);
       else
           printf("%i months\n",i);
   }
}
