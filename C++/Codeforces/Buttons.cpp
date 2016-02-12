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
   scanf("%i",&n);

   int temp = n-1;
   int count = 1;
   int ans = n;
   while(temp != 0)
   {
       ans += temp*count;
       count++;
       temp--;
   }

   printf("%i",ans);

}
