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

using namespace std;

long int reduce(long int num);
int main()
{
   long int n;
   scanf("%d",&n);

   long int a;
   scanf("%d",&a);
   long int target = reduce(a);
   for(int i = 1; i < n; i++)
   {
       long int num;
       scanf("%d",&num);
       if (target != reduce(num))
       {
           printf("%s","No");
           return 0;
       }
   }
   printf("%s","Yes");
}

long int reduce(long int num)
{
   while(true)
   {
       if (num%2 == 0)
           num /= 2;
       else if (num%3 == 0)
           num /= 3;
       else
           break;
   }

   return num;
}
