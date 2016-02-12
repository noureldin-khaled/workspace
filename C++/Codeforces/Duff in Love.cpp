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

bool isLovely(long long num);
int main()
{
   long long num;
   scanf("%I64d",&num);
   vector<long long> v;
   long long square_root = (long long) sqrt(num) + 1;
   for (long long i = 1; i < square_root; i++){
       if (num % i == 0) {
           v.push_back(i);
           v.push_back(num/i);
       }
   }

   sort(v.begin() ,v.end());
   reverse(v.begin() ,v.end());

   for(vector<long long>::iterator i = v.begin(); i != v.end(); i++)
   {
       long long element = *i;
       if (isLovely(element))
       {
           printf("%I64d",element);
           return 0;
       }
   }
}

bool isLovely(long long num)
{
   for(long long i = 2; i*i <= num; i++)
   {
       if (num%(i*i) == 0)
           return false;
   }
   return true;
}
