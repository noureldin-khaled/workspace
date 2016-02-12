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
#define INF 32000

using namespace std;

int M,C;
int price[25][25];
int dp[220][25];

int rec(int money,int g);
int main()
{
   int t;
   scanf("%i",&t);

   while(t--)
   {
       scanf("%d %d",&M,&C);
       for(int i = 0; i < C; i++)
       {
           scanf("%d",&price[i][0]);
           for(int j = 1; j <= price[i][0]; j++)
               scanf("%d",&price[i][j]);
       }

       memset(dp,-1,sizeof(dp));

       int ans = rec(M,0);
       if (ans < 0)
           printf("no solution\n");
       else
           printf("%d\n",ans);
   }
}

int rec(int money,int g)
{
   if (money < 0)
       return -INF;
   if (g == C)
       return M-money;

   if (dp[money][g] != -1)
       return dp[money][g];

   int ans = -1;
   for(int i = 1; i <= price[g][0]; i++)
       ans = max(ans,rec(money-price[g][i],g+1));

   return dp[money][g] = ans;
}
