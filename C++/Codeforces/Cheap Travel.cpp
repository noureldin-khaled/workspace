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

using namespace std;

long long dp[1001];
long long m;
long long a;
long long b;

long long rec(int n);
int main()
{
   int n;
   cin >> n >> m >> a >> b;

   for(int i = 0;i < 1001;i++)
       dp[i] = -1;

   long long ans = rec(n);

   cout << ans << endl;
}

long long rec(int n){
   if (n <= 0)
       return 0;

   if (dp[n] != -1)
       return dp[n];

   int choice1 = rec(n-1) + a;
   int choice2 = rec(n-m) + b;

   if (choice1 < choice2)
       return dp[n] = choice1;
   else
       return dp[n] = choice2;
}
