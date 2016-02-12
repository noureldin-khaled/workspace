#include <bits/stdc++.h>

using namespace std;

int main()
{
   int n;
   scanf("%i",&n);

   vector<int> adjlist[n];

   for (int u = 0; u < n; u++)
   {
       int c;
       scanf("%i",&c);

       for (int i = 0; i < c; i++)
       {
           int v;
           scanf("%i",&v);

           adjlist[u].push_back(v);
       }
   }

   int t;
   scanf("%i",&t);
   while(t--)
   {
       int s;
       scanf("%i",&s);

       int dist[n];
       memset(dist, -1, sizeof dist);
       queue<int> q;
       q.push(s);
       dist[s] = 0;

       while(!q.empty())
       {
           int u = q.front();
           q.pop();

           for (int i = 0; i < adjlist[u].size(); i++)
           {
               int v = adjlist[u][i];
               if (dist[v] == -1)
               {
                   dist[v] = dist[u] + 1;
                   q.push(v);
               }
           }
       }

       int level[n];
       memset(level, 0, sizeof level);
       for (int i = 0; i < n; i++)
           level[dist[i]]++;

       int maximum = 0;
       int day = 0;
       for (int i = 1; i < n; i++)
       {
           if (level[i] > maximum)
           {
               maximum = level[i];
               day = i;
           }
       }

       if (day == 0)
           printf("%i\n", 0);
       else
           printf("%i %i\n", maximum, day);
   }
}
