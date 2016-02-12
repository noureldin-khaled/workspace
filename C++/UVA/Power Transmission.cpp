#include <bits/stdc++.h>
#define MAX 300
#define INF 1000000000

using namespace std;

const int IN = 0;
const int OUT = 1;

int res[MAX][MAX];
int s;
int t;
int V;

int pushRelabel();
int main()
{
   int n;
   while(scanf("%i",&n) != EOF)
   {
       for (int i = 0; i < MAX; i++)
           for (int j = 0; j < MAX; j++)
               res[i][j] = 0;

       int arr[n][2];

       int c = 0;
       for (int i = 0; i < n; i++)
           for (int j = 0; j < 2; j++)
               arr[i][j] = c++;


       for (int u = 0; u < n; u++)
       {
           int w;
           scanf("%i",&w);

           res[arr[u][IN]][arr[u][OUT]] = w;
       }

       int m;
       scanf("%i",&m);

       for (int i = 0; i < m; i++)
       {
           int u, v, w;
           scanf("%i %i %i",&u, &v, &w);
           u--;v--;

           res[arr[u][OUT]][arr[v][IN]] = w;
       }

       s = c++;
       t = c++;

       int b, d;
       scanf("%i %i",&b, &d);

       for (int i = 0; i < b; i++)
       {
           int src;
           scanf("%i",&src);
           src--;

           res[s][arr[src][IN]] = INF;
       }

       for (int i = 0; i < d; i++)
       {
           int dest;
           scanf("%i",&dest);
           dest--;

           res[arr[dest][OUT]][t] = INF;
           res[t][arr[dest][IN]] = INF;
       }

       V = 2*n + 2;
       int ans = pushRelabel();
       printf("%i\n",ans);
   }
}

int pushRelabel()
{
   int level[V];
   int e[V];
   int flow[V][V];

   memset(level, 0 , sizeof level);
   memset(e, 0, sizeof e);
   for (int i = 0; i < V; i++)
       for (int j = 0; j < V; j++)
           flow[i][j] = 0;

   level[s] = V-1;

   queue<int> q;
   bool isActive[V];
   memset(isActive, false, sizeof isActive);

   for (int i = 0; i < V; i++)
   {
       flow[i][s] = -(flow[s][i] = e[i] = res[s][i]);

       if (i != s && i != t && e[i] > 0)
       {
           isActive[i] = true;
           q.push(i);
       }
   }

   while(!q.empty())
   {
       int u = q.front();
       bool pushed = false;
       for (int v = 0; v < V && e[u] != 0; v++)
       {
           if (level[u] == level[v] + 1 && res[u][v] - flow[u][v] > 0)
           {
               int df = min(e[u], res[u][v] - flow[u][v]);
               flow[u][v] += df; flow[v][u] -= df;
               e[u] -= df; e[v] += df;

               if (v != s && v != t && !isActive[v])
               {
                   isActive[v] = true;
                   q.push(v);
               }
               pushed = true;
           }
       }

       if (e[u] == 0)
       {
           isActive[u] = false;
           q.pop();
       }

       if (!pushed)
       {
           level[u] = INF;
           for (int v = 0; v < V; v++)
               if (level[v] + 1 < level[u] && res[u][v] - flow[u][v] > 0)
                   level[u] = level[v] + 1;
       }
   }

   return e[t];
}
