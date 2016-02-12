#include <bits/stdc++.h>
#define MAX 210

using namespace std;

vector<int> adjlist[MAX];
bool visited[MAX];

void dfs(int u);
int main()
{
   int n, m;
   scanf("%i %i",&n, &m);

   bool em = true;
   for(int i = 0; i < n; i++)
   {
       int k;
       scanf("%i",&k);

       for(int j = 0; j < k; j++)
       {
           em = false;
           int l;
           scanf("%i",&l);
           l = l-1 + n;
           adjlist[i].push_back(l);
           adjlist[l].push_back(i);
       }
   }
   memset(visited, false, sizeof visited);

   int ans = 0;
   for(int i = 0; i < n; i++)
       if (!visited[i])
       {
           dfs(i);
           ans++;
       }
   if (!em)
       ans--;
   printf("%i",ans);
}

void dfs(int u)
{
   visited[u] = true;

   for(int i = 0; i < adjlist[u].size(); i++)
   {
       int v = adjlist[u][i];
       if (!visited[v])
           dfs(v);
   }
}
