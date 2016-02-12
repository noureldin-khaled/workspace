#include <bits/stdc++.h>
#define MAX 200

using namespace std;

vector<int> adjlist[MAX];
bool visited[MAX];
int counter;

void dfs(int u);
int main()
{
   while(true)
   {
       for (int i = 0; i < MAX; i++)
           adjlist[i].clear();

       memset(visited, false, sizeof visited);
       int n;
       scanf("%i",&n);

       if (n == -1) break;

       double radii[n];
       pair<double, double> centers[n];

       for (int i = 0; i < n; i++)
       {
           double x, y, r;
           cin >> x >> y >> r;

           centers[i] = make_pair(x, y);
           radii[i] = r;
       }

       for (int i = 0; i < n; i++)
       {
           for (int j = 0; j < n; j++)
           {
               if (i == j) continue;
               double d = (centers[i].first - centers[j].first)*(centers[i].first - centers[j].first) + (centers[i].second - centers[j].second)*(centers[i].second - centers[j].second);
               double tr = (radii[i] + radii[j]) * (radii[i] + radii[j]);
               double ab = (double)fabs(radii[i] - radii[j]) * fabs(radii[i] - radii[j]);

               if (d <= tr && d > ab)
                   adjlist[j].push_back(i);
           }
       }

       int maximum = 0;
       for (int i = 0; i < n; i++)
       {
           if (!visited[i])
           {
               counter = 0;
               dfs(i);
               maximum = max(counter, maximum);
           }
       }
       if (maximum == 1)
           printf("The largest component contains %d ring.\n", maximum);
       else
           printf("The largest component contains %d rings.\n", maximum);

   }
}

void dfs(int u)
{
   visited[u] = true;
   counter++;

   for (int i = 0; i < adjlist[u].size(); i++)
   {
       int v = adjlist[u][i];
       if (!visited[v])
           dfs(v);
   }
}
