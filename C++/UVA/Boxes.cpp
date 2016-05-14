#include <bits/stdc++.h>
#define MAX 1005
#define INF 1000000000

using namespace std;

int weights[MAX];
int maxWeights[MAX];
int dp[MAX][5000];
int n;


int rec(int index, int smallestWeight);
int main()
{
    while(true)
    {
        scanf("%i", &n);

        if (n == 0) break;

        for (int i = 0; i < n; i++)
        {
            int w, m;
            scanf("%i%i", &w, &m);

            weights[i] = w;
            maxWeights[i] = m;
        }

        for (int i = 0; i < MAX; i++)
            for (int j = 0; j < 5000; j++)
                dp[i][j] = -1;

        printf("%i\n", rec(0, INF));
    }
}

int rec(int index, int smallestWeight)
{
    if (index == n)
        return 0;

    if (smallestWeight < INF && dp[index][smallestWeight] != -1)
        return dp[index][smallestWeight];

    int take = 0;
    if (smallestWeight - weights[index] >= 0)
        take = rec(index + 1, min(maxWeights[index], smallestWeight - weights[index])) + 1;
    int leave = rec(index + 1, smallestWeight);

    int ans = max(take, leave);
    if (smallestWeight < INF)
        dp[index][smallestWeight] = ans;
    return  ans;
}
