#include <bits/stdc++.h>
#define MAX 100005

using namespace std;

vector<int> adjlist[MAX];
int dfs_num[MAX];
int dfs_low[MAX];
int SCCid[MAX];
stack<int> s;
int dfsCounter;
int n;
int SCC;

void tarjan();
void tarjan(int u);
int main()
{
   int t;
   scanf("%i",&t);

   while(t--)
   {
       for (int i = 0; i < MAX; i++)
           adjlist[i].clear();

       int m;
       scanf("%i %i",&n, &m);

       for(int i = 0; i < m; i++)
       {
           int u, v;
           scanf("%i %i",&u, &v);
           u--; v--;

           adjlist[u].push_back(v);
       }

       memset(dfs_low, 0, sizeof dfs_low);
       memset(dfs_num, 0, sizeof dfs_num);
       memset(SCCid, -1, sizeof SCCid);
       SCC = 0;

       tarjan();

       int inDegree[SCC];
       memset(inDegree, 0, sizeof inDegree);

       for (int u = 0; u < n; u++)
       {
           for (int j = 0; j < adjlist[u].size(); j++)
           {
               int v = adjlist[u][j];
               if (SCCid[u] != SCCid[v])
                   inDegree[SCCid[v]]++;
           }
       }

       int ans = 0;
       for (int i = 0; i < SCC; i++)
           if (inDegree[i] == 0)
               ans++;

       printf("%i\n",ans);
   }

}

void tarjan()
{
   for (int i = 0; i < n; i++)
       if (dfs_num[i] == 0)
           tarjan(i);
}

void tarjan(int u)
{
   dfs_num[u] = dfs_low[u] = ++ dfsCounter;
   s.push(u);

   for(int i = 0; i < adjlist[u].size(); i++)
   {
       int v = adjlist[u][i];
       if (dfs_num[v] == 0)
           tarjan(v);
       if (SCCid[v] == -1)
           dfs_low[u] = min(dfs_low[u], dfs_low[v]);
   }

   if (dfs_num[u] == dfs_low[u])
   {
       while(true)
       {
           int v = s.top();
           s.pop();
           SCCid[v] = SCC;
           if (v == u)
               break;
       }
       SCC++;
   }
}
