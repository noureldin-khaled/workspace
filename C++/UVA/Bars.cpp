#include <bits/stdc++.h>

using namespace std;

int arr[25];
int dp[25][1005];

bool rec(int index, int remN);
int main()
{
   int t;
   scanf("%i",&t);

   while(t--)
   {
       int n, p;
       scanf("%i",&n);
       scanf("%i",&p);

       memset(arr, 0, sizeof arr);
       for(int i = 0; i < p; i++)
           scanf("%i",&arr[i]);

       memset(dp, -1, sizeof dp);
       bool ans = rec(0, n);
       if (ans)
           puts("YES");
       else
           puts("NO");
   }

}

bool rec(int index, int remN)
{
   if (remN == 0)
       return true;
   if (remN < 0 || index == 25)
       return false;

   if (dp[index][remN] == 0)
       return false;
   if (dp[index][remN] == 1)
       return true;

   bool take = rec(index+1, remN-arr[index]);
   bool leave = rec(index+1, remN);

   if (take || leave)
       dp[index][remN] = 1;
   else
       dp[index][remN] = 0;

   return take || leave;
}
