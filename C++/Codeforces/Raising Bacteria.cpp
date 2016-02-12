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
   long int x;
   scanf("%d",&x);

   long int i = 0;
   long int temp = x;
   long int ans = 0;

   while(true)
   {
       if ((1 << i) == temp)
       {
           ans++;
           break;
       }
       if ((1 << (i+1)) > temp)
       {
           ans++;
           temp = temp-(1 << i);
           i = 0;
       }
       else
           i++;
   }
   printf("%d",ans);

}
