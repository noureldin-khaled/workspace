#include <bits/stdc++.h>
#define MAX 10005

using namespace std;

int dp[MAX];

int a, b;
bool rec(int rem);
int main()
{
    int c;
    scanf("%i %i %i",&a, &b, &c);

    memset(dp, -1, sizeof dp);
    if (rec(c))
        puts("Yes");
    else
        puts("No");
}

bool rec(int rem)
{
    if (rem == 0)
        return true;
    if (rem < 0)
        return false;

    if (dp[rem] != -1)
        return dp[rem] == 0 ? false : true;

    bool choice1 = rec(rem - a);
    bool choice2 = rec(rem - b);

    if (choice1 || choice2)
    {
        dp[rem] = 1;
        return true;
    }
    else
    {
        dp[rem] = 0;
        return false;
    }
}
