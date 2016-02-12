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

   long int arr[39];
   long int arr2[39];

   arr[0] = 1;
   arr2[0] = 1;
   for(int i = 1; i < 39; i++)
       arr[i] = arr[i-1]+i+1;

   for(int i = 1; i < 39; i++)
       arr2[i] = arr[i] + arr2[i-1];

   for(int i = 0; i < 38; i++)
   {
       if (arr2[i+1] > n)
       {
           printf("%i",i+1);
           return 0;
       }
   }

}
