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

#define INF 30000
using namespace std;
int a,b,c;
int dp[4005];

int rec(int w);
int main()
{
   int n;
   scanf("%i %i %i %i",&n,&a,&b,&c);

   for(int i = 0; i < 4005; i++)
       dp[i] = -1;
   int ans = rec(n);
   printf("%i",ans);
}

int rec(int w)
{
   if (w == 0)
       return 0;
   if (w < 0)
       return -INF;

   if (dp[w] != -1)
       return dp[w];

   int choice1 = rec(w-a) + 1;
   int choice2 = rec(w-b) + 1;
   int choice3 = rec(w-c) + 1;

   return dp[w] = max(max(choice1,choice2),choice3);

}
