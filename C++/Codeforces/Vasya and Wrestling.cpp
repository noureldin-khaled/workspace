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
   scanf("%d",&n);

   vector<int> first;
   vector<int> second;

   long long sumFirst = 0;
   long long sumSecond = 0;
   int lastMove = 0;

   for(int i = 0; i < n; i++)
   {
       int a;
       scanf("%d",&a);
       if (a > 0) {
           first.push_back(a);
           sumFirst += a;
       }
       else {
           second.push_back(a*-1);
           sumSecond += (a*-1);
       }
       if (i == n-1)
           lastMove = a;
   }

   if (sumFirst > sumSecond)
       puts("first");
   else if (sumSecond > sumFirst)
       puts("second");
   else
   {
       int firstSize = first.size();
       int secondSize = second.size();
       int smallSize = min(firstSize,secondSize);

       for(int i = 0; i < smallSize; i++)
       {
           if (first[i] > second[i])
           {
               puts("first");
               return 0;
           }
           if (first[i] < second[i])
           {
               puts("second");
               return 0;
           }
       }

       if (firstSize > secondSize)
           puts("first");
       else if (secondSize > firstSize)
           puts("second");
       else
       {
           if (lastMove > 0)
               puts("first");
           else
               puts("second");
       }
   }
}
