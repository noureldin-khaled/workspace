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
#define mod 1000000007

using namespace std;

long int modulo(long int x);
int main()
{
   long int x,y;
   scanf("%d %d",&x,&y);

   long int n;
   scanf("%d",&n);

   long int f1 = x;
   long int f2 = y;
   long int f3 = y-x;

   if (n == 1)
       printf("%d",modulo(f1));
   else if (n == 2)
       printf("%d",modulo(f2));
   else if (n == 3)
       printf("%d",modulo(f3));
   else {
       int num = 1;
       while(true)
       {
           if (n <= 3)
               break;
           n -= 3;
           num *= -1;
       }
       if (n == 1)
           printf("%d",modulo(f1*num));
       if (n == 2)
           printf("%d",modulo(f2*num));
       if (n == 3)
           printf("%d",modulo(f3*num));
       }
}

long int modulo(long int x){
       return ((x%mod)+mod)%mod;
}
