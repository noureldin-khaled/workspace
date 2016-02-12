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

int gcd(int a,int b);
int main()
{
   int a,b,n;
   scanf("%i %i %i",&a,&b,&n);

   int turn = 0;
   while(true)
   {
       if (turn == 0)
       {
           int num = gcd(a,n);
           if (n < num)
           {
               printf("%i",1);
               return 0;
           }
               n-=num;
       }
       else
       {
           int num = gcd(b,n);
           if (n < num)
           {
               printf("%i",0);
               return 0;
           }
               n-=num;
       }
       turn = 1-turn;
   }
}

int gcd( int a,  int b) {
   return b == 0 ? a : gcd(b, a % b);
}
