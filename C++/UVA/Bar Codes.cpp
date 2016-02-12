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
int n,k,m;
long long dp[100][3005];

long long BC(int index ,int length);
int main()
{
   while(cin >> n >> k >> m)
   {
       for(int i = 0; i < 100; i++)
           for(int j = 0; j < 3005; j++)
               dp[i][j] = -1;


       long long ans = BC(0,0);
       printf("%I64d\n",ans);
   }

}

long long BC(int index ,int length)
{
   if (length == n && index == k)
       return 1;
   if (index == k)
       return 0;

   if (dp[index][length] != -1) return dp[index][length];

   long long ans = 0;
   for(int i = 1; i <= m; i++)
       ans += BC(index+1,length+i);

   return dp[index][length] = ans;
}
