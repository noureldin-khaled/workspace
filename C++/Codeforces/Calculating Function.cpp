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
   long long n;
   scanf("%I64d",&n);

   long long ans = n/2;
   if (n%2 != 0)
   {
       ans++;
       ans *= -1;
   }
   printf("%I64d",ans);
}
