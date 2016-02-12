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
   long int n;
   scanf("%d",&n);

   string arr[5] = {"Sheldon","Leonard","Penny","Rajesh","Howard"};

   if (n <= 5)
   {
       cout << arr[n-1];
       return 0;
   }

   long int round[10000];
   long int turns[10000];
   round[0] = 1;
   turns[0] = 5;

   for(long int i = 1; i < 28; i++)
   {
       round[i] = round[i-1]*2;
       turns[i] = turns[i-1] + round[i]*5;
   }

   for(long int i = 0; i < 27; i++)
   {
       if (turns[i] == n)
       {
           puts("Howard");
           return 0;
       }
       if (turns[i+1] > n)
       {
           int index = (n-turns[i])/round[i+1];
           if ((n-turns[i])%round[i+1] == 0) index--;
           cout << arr[index];
           return 0;
       }
   }

}
