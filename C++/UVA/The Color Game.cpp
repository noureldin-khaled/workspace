#include <bits/stdc++.h>

using namespace std;

int main()
{
   int g = 1;
   while(true)
   {
       int n;
       scanf("%i",&n);
       if (n==0)break;

       int arr[n][n];
       for (int i = 0; i < n; i++)
           for (int j = 0; j < n; j++)
           {
               scanf("%i",&arr[i][j]);
               arr[i][j]--;
           }

       int N1, N2, N3;
       scanf("%i %i %i", &N1, &N2, &N3);
       N1--;N2--;N3--;

       int dist[n][n];
       memset(dist, -1, sizeof dist);
       dist[N1][N2] = 0;

       queue<pair<int, int> > q;
       q.push(make_pair(N1, N2));

       int ans = -1;
       while(!q.empty())
       {
           pair<int, int> cur = q.front();
           q.pop();
           int curN1 = cur.first;
           int curN2 = cur.second;

           if (curN1 == N3 || curN2 == N3)
           {
               ans = dist[curN1][curN2];
               break;
           }

           if (arr[curN1][curN2] != -1)
           {
               int newN1 = arr[curN1][curN2];
               if (dist[newN1][curN2] == -1)
               {
                   dist[newN1][curN2] = dist[curN1][curN2] + 1;
                   q.push(make_pair(newN1, curN2));
               }
           }

           if (arr[curN2][curN1] != -1)
           {
               int newN2 = arr[curN2][curN1];
               if (dist[curN1][newN2] == -1)
               {
                   dist[curN1][newN2] = dist[curN1][curN2] + 1;
                   q.push(make_pair(curN1, newN2));
               }
           }

       }

       printf("Game #%i\n", g++);
       if (ans == -1)
           puts("Destination is Not Reachable !\n");
       else
           printf("Minimum Number of Moves = %i\n\n", ans);
   }
}
