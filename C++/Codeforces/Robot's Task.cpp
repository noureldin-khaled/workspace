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

int main()
{
   int n;
   scanf("%i",&n);

   int arr[n];
   for(int i = 0; i < n; i++)
       scanf("%i",&arr[i]);

   int done = 0;
   int turns = 0;
   int info = 0;
   while(true)
   {
//        cout << "h" << endl;
       if (done == n)
           break;
       for(int i = 0; i < n; i++)
       {
           if (arr[i] != -1 && info >= arr[i])
           {
               done++;
               info++;
               arr[i] = -1;
           }
       }

       if (done == n)
           break;
       turns++;

       for(int i = n-1; i >= 0; i--)
       {
           if (arr[i] != -1 && info >= arr[i])
           {
               done++;
               info++;
               arr[i] = -1;
           }
       }
       if (done == n)
           break;
       turns++;
   }

   printf("%i",turns);
}
