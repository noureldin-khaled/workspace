#include <bits/stdc++.h>
#define MAX 200
#define INF 1000000000

using namespace std;

int res[MAX][MAX];
int n, s, t;

int pushRelabel();
int main()
{

   int c = 1;
   while(true)
   {
       scanf("%i",&n);
       if (n == 0) break;

       for (int i = 0; i < MAX; i++)
           for (int j = 0; j < MAX; j++)
               res[i][j] = 0;

       int m;
       scanf("%i %i %i",&s, &t, &m);
       s--;t--;

       for (int i = 0; i < m; i++)
       {
           int u, v, w;
           scanf("%i %i %i",&u, &v, &w);
           u--;v--;

           res[u][v] += w;
           res[v][u] += w;
       }

       int mf = pushRelabel();
       printf("Network %i\n",c++);
       printf("The bandwidth is %i.\n\n",mf);
   }
}

int pushRelabel()
{
   int level[n];
   int e[n];
   int flow[n][n];
   memset(level, 0, sizeof level);
   memset(e, 0, sizeof e);
   for (int i = 0; i < n; i++)
       for (int j = 0; j < n; j++)
           flow[i][j] = 0;

   level[s] = n-1;

   queue<int> q;
   bool isActive[n];
   memset(isActive, false, sizeof isActive);

   for(int i = 0; i < n; ++i)
   {
       flow[i][s] = -(flow[s][i] = e[i] = res[s][i]);
       if(i != s && i != t && e[i] > 0)
       {
           isActive[i] = true;
           q.push(i);
       }
   }

   while(!q.empty())
   {
       int u = q.front();
       bool pushed= false;
       for (int v = 0; v < n && e[u] != 0; v++)
       {
           if(level[u] == level[v] + 1 &&  res[u][v] - flow[u][v] > 0)
           {
               int df = min(e[u], res[u][v] - flow[u][v]);
               flow[u][v] += df; flow[v][u] -= df;
               e[u] -= df; e[v] += df;
               if(v != s && v != t && !isActive[v])
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
           for (int v = 0; v < n; v++)
               if (level[v] + 1 < level[u] && res[u][v] - flow[u][v] > 0)
                   level[u] = level[v] + 1;
       }
   }

   return e[t];

}
