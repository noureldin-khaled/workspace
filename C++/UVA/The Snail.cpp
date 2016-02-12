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
       int h,u,d,f;
       scanf("%i %i %i %i",&h,&u,&d,&f);

       if (h == 0)
           break;

       double distanceClimbed = 0;
       double up = u;
       double subtract = (f*1.0)/100 * up;
       int day = 0;
       do
       {
           day++;
           if (up >= 0)
               distanceClimbed += up;
           if (distanceClimbed > h)
               break;

           distanceClimbed -= d;
           if (distanceClimbed < 0)
               break;

           up -= subtract;
       }while(true);

       if (distanceClimbed < 0)
           printf("failure on day %i\n",day);
       else
           printf("success on day %i\n",day);
   }
}
