#include <bits/stdc++.h>
#define MAX 30
#define INF 1000000000
#define to_string(x) dynamic_cast< std::ostringstream & >( \
       ( std::ostringstream() << std::dec << x ) ).str()
#define to_int(x) atoi(x.c_str())

using namespace std;

int n;
vector<int> adjlist[MAX];
bool visited[MAX];
vector<vector<int> > res;
int num;
int dist[MAX][MAX];

void dfs(int u, vector<int> path);
int main()
{
  int c = 1;
  while(scanf("%i", &n) != EOF)
  {
    for (int i = 0; i < MAX; i++)
      adjlist[i].clear();
    for (int i = 0; i < MAX; i++)
      for (int j = 0; j<  MAX; j++)
        dist[i][j] = INF;

    for (int i = 0; i < MAX; i++)
      dist[i][i] = 0;

    while(true)
    {
      int u, v;
      scanf("%i %i",&u, &v);
      if (u == 0 && v == 0) break;
      u--;v--;
      dist[u][v] = dist[v][u] = 1;
      adjlist[u].push_back(v);
      adjlist[v].push_back(u);
    }

    for(int k = 0; k < MAX; k++)
		    for(int i = 0; i < MAX; i++)
				    for(int j = 0; j < MAX; j++)
				        if(dist[i][j] > dist[i][k] + dist[k][j])
						      dist[i][j] = dist[i][k] + dist[k][j];

    memset(visited, false, sizeof visited);
    printf("CASE %d:\n", c++);
    num = 0;
    res.clear();
    vector<int> path;
    dfs(0, path);

    sort(res.begin(), res.end());
    for (int i = 0; i < res.size(); i++)
    {
      for (int j = 0; j<  res[i].size(); j++)
      {
        if (j > 0)
          printf(" %i",res[i][j]);
        else
          printf("%i",res[i][j]);
      }
      cout << endl;
    }
    printf("There are %d routes from the firestation to streetcorner %d.\n", num, n);
  }
}

void dfs(int u, vector<int> path)
{
  if (u == n-1)
  {
    num++;
    path.push_back(n);
    res.push_back(path);
    return;
  }

  if (dist[u][n-1] == INF)
    return;

  visited[u] = true;

  for (int i = 0; i < adjlist[u].size(); i++)
  {
    int v = adjlist[u][i];
    if (!visited[v])
    {
      vector<int> newPath;
      for (int i = 0; i < path.size(); i++)
        newPath.push_back(path[i]);
      newPath.push_back(u+1);
      dfs(v, newPath);
    }


  }
  visited[u] = false;
}
