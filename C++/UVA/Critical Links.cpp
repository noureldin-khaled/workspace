#include <bits/stdc++.h>
#define MAX 1000004
#define to_int(x) atoi(x.c_str())

using namespace std;

vector<int> adjlist[MAX];
vector<pair<int, int> > bridges;
int dfs_num[MAX];
int dfs_low[MAX];
int parent[MAX];
int n;
int dfsCounter;

void findBridges();
void dfs(int u);
int main()
{
   while(scanf("%i",&n) != EOF)
   {
       for (int i = 0; i < MAX; i++)
           adjlist[i].clear();

       for (int i = 0; i < n; i++)
       {
           int u;
           scanf("%i",&u);
           string temp;
           cin >> temp;

           string num = temp.substr(1, temp.length()-2);
           int m = to_int(num);
           for (int j = 0; j < m; j++)
           {
               int v;
               scanf("%i",&v);

               adjlist[u].push_back(v);
           }
       }

       bridges.clear();
       memset(dfs_num, 0, sizeof dfs_num);
       memset(dfs_low, 0, sizeof dfs_low);
       memset(parent, 0, sizeof parent);
       dfsCounter = 0;

       findBridges();
       sort(bridges.begin(), bridges.end());

       int len = bridges.size();
       printf("%i critical links\n",len);
       for (int i = 0; i < len; i++)
           printf("%i - %i\n",bridges[i].first, bridges[i].second);
       puts("");
   }
}

void findBridges()
{
   for (int i = 0; i < n; i++)
       if (dfs_num[i] == 0)
           dfs(i);
}

void dfs(int u)
{
   dfs_num[u] = dfs_low[u] = ++dfsCounter;
   for (int i = 0; i < adjlist[u].size(); i++)
   {
       int v = adjlist[u][i];
       if (dfs_num[v] == 0)
       {
           parent[v] = u;
           dfs(v);
           if (dfs_low[v] > dfs_num[u])
               bridges.push_back(make_pair(min(u, v), max(u,v)));
           dfs_low[u] = min(dfs_low[v], dfs_low[u]);
       }
       else
           if (parent[u] != v)
               dfs_low[u] = min(dfs_low[u], dfs_num[v]);
   }
}
