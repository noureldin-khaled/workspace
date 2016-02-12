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
       string s;
       cin >> s;

       if (s.compare("0:00") == 0) break;

       string h = "";
       string m = "";
       int i = 0;
       for(; i < s.length(); i++)
       {
           if (s[i] == ':')
               break;
           h += s[i];
       }
       i++;
       for(; i < s.length(); i++)
           m += s[i];

       int hour = toInt(h);
       int minute = toInt(m);

       double minuteAngle = minute*6;
       double hourAngle = hour*30 + (minute*0.5);
       double ans1 = abs(minuteAngle-hourAngle);
       double ans2 = 360 -ans1;

       double ans = min(ans1,ans2);
       printf("%.3f\n",ans);
   }
}
