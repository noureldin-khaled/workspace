#include <bits/stdc++.h>

using namespace std;

vector<int> adjlist[2005];

int bfs(int s);
int main()
{
   int n;
   scanf("%i",&n);

   vector<int> v;
   for(int i = 0; i < n; i++)
   {
       int parent;
       scanf("%i",&parent);
       parent--;
       if (parent == -2) v.push_back(i);

       adjlist[parent].push_back(i);
   }

   int ans = 0;
   for (int i = 0; i < v.size(); i++)
       ans = max(ans, bfs(v[i]));

   printf("%i",ans);
}

int bfs(int s)
{
   int dist[2005];
   memset(dist, -1, sizeof dist);
   queue<int> q;
   dist[s] = 1;
   q.push(s);

   while(!q.empty())
   {
       int u = q.front();
       q.pop();

       for(int i = 0; i < adjlist[u].size(); i++)
       {
           int v = adjlist[u][i];
           if (dist[v] == -1)
           {
               dist[v] = dist[u] + 1;
               q.push(v);
           }
       }
   }

   int maximum = 0;
   for(int i = 0; i < 2005; i++)
       maximum = max(maximum, dist[i]);
   return maximum;
}
