#include<iostream>
#include<string>
#include<cstring>
#include<sstream>
#include<string.h>
#include<algorithm>
#include<cmath>
#include<fstream>
#include<cstdlib>
#include<vector>
#include<stdlib.h>
#include<set>
#include<stdio.h>
#include<limits>

using namespace std;

int main()
{
   long int n,x;
   scanf("%d %d",&n,&x);

   long int counter = 0;
   for(long int i = 1; i <= n; i++)
   {
       if (x%i == 0 && (x/i) <=n)
           counter++;
   }
   printf("%d",counter);
}
