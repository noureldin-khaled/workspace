#include <bits/stdc++.h>
#define MAX 1000

using namespace std;

vector<int> adjlist[MAX];
int dfs_num[MAX];
int dfs_low[MAX];
int parent[MAX];
int n, dfsCounter, root, rootChildren;
bool articulationPoint[MAX];

void artPoints();
void dfs(int u);
int main()
{
   int t = 1;
   while(true)
   {
       scanf("%i",&n);
       if (n == 0) break;

       if (t != 1)
           puts("");
       map<string, int> m;
       string names[MAX];

       for (int i = 0 ;i < n; i++)
       {
           string city;
           cin >> city;

           m[city] = i;
           names[i] = city;
       }

       for (int i = 0; i < MAX; i++)
           adjlist[i].clear();

       int e;
       scanf("%i",&e);

       for (int i = 0; i < e; i++)
       {
           string from, to;
           cin >> from >> to;
           int u = m.find(from)->second;
           int v = m.find(to)->second;

           adjlist[u].push_back(v);
           adjlist[v].push_back(u);
       }

       memset(dfs_num, 0, sizeof dfs_num);
       memset(dfs_low, 0, sizeof dfs_low);
       memset(parent, -1, sizeof parent);
       memset(articulationPoint, false, sizeof articulationPoint);
       dfsCounter = 0;

       artPoints();

       vector<string> res;

       for (int i = 0; i < n; i++)
           if (articulationPoint[i])
               res.push_back(names[i]);

       sort(res.begin(), res.end());

       int s = res.size();
       printf("City map #%i: %i camera(s) found\n", t++, s);
       for (int i = 0; i < s; i++)
           cout << res[i] << endl;
   }
}

void artPoints()
{
   for (int i = 0; i < n; i++)
       if (dfs_num[i] == 0)
       {
           root = i;
           rootChildren = 0;
           dfs(i);
           if (rootChildren <= 1)
               articulationPoint[i] = false;
       }
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
           if (u == root)
               rootChildren++;

           dfs(v);
           if (dfs_low[v] >= dfs_num[u])
               articulationPoint[u] = true;

           dfs_low[u] = min(dfs_low[v], dfs_low[u]);
       }
       else
           if (parent[u] != v)
               dfs_low[u] = min(dfs_low[u], dfs_num[v]);
   }
}
