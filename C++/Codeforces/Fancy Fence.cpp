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
   set<int> angles;
   for(int n = 3; n <= 360; n++)
   {
       if (360%n == 0) {
           int angle = 180-(360/n);
           angles.insert(angle);
       }
   }

   int t;
   scanf("%i",&t);

   while(t--)
   {
       int a;
       scanf("%i",&a);

       if (angles.find(a) == angles.end())
           puts("NO");
       else
           puts("YES");
   }
}
