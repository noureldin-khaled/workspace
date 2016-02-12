#include <bits/stdc++.h>
#define MAX 100005

using namespace std;

vector<pair<int, long long> > adjlist[MAX];
int inDegrees[MAX];
bool visited[MAX];
long long max_weight;

void dfs(int u, long long weightSoFar);
int main()
{
   int n;
   scanf("%i",&n);

   long long ans = 0;
   memset(visited, false, sizeof visited);
   memset(inDegrees, 0, sizeof inDegrees);
   for (int i = 0; i < n-1; i++)
   {
       int u, v, w;
       scanf("%i %i %i",&u, &v, &w);
       u--;v--;

       adjlist[u].push_back(make_pair(v, w));
       adjlist[v].push_back(make_pair(u, w));
       ans += w*2;
       inDegrees[u]++;
       inDegrees[v]++;
   }

   max_weight = 0;
   dfs(0, 0);

   ans -= max_weight;
   cout << ans << endl;
}

void dfs(int u, long long weightSoFar)
{
   visited[u] = true;
   if (inDegrees[u] == 1 && u != 0)
   {
       max_weight = max(max_weight, weightSoFar);
       return;
   }

   for (int i = 0; i < adjlist[u].size(); i++)
   {
       pair<int, int> v = adjlist[u][i];
       if (!visited[v.first])
           dfs(v.first, weightSoFar+v.second);
   }
}
