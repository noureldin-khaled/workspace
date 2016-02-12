#include <bits/stdc++.h>

using namespace std;

int main()
{

   int t;
   scanf("%i",&t);

   while(t--)
   {
       int n, exit, T, m;
       scanf("%i", &n);
       scanf("%i", &exit);
       scanf("%i", &T);
       scanf("%i", &m);
       exit--;

       vector<pair<long long, int> > adjlist[n];

       for (int i = 0; i < m; i++)
       {
           int u, v, w;
           scanf("%i %i %i",&u, &v, &w);
           u--;v--;

           adjlist[v].push_back(make_pair(w, u));
       }

       long long dist[n];
       memset(dist, -1, sizeof dist);

       priority_queue<pair<long long, int>, vector<pair<long long, int> >, greater<pair<long long, int> > > pq;
       dist[exit] = 0;
       pq.push(make_pair(0 ,exit));

       while(!pq.empty())
       {
           pair<long long, int> cur = pq.top();
           pq.pop();

           if (cur.first > dist[cur.second])
               continue;

           for (int i = 0; i < adjlist[cur.second].size(); i++)
           {
               pair<long long, int> next = adjlist[cur.second][i];
               if (dist[next.second] == -1 || cur.first + next.first < dist[next.second])
               {
                   dist[next.second] = cur.first + next.first;
                   pq.push(make_pair(dist[next.second], next.second));
               }
           }
       }

       int ans = 0;
       for (int i = 0; i < n; i++)
       {
           if (dist[i] != -1 && dist[i] <= T)
               ans++;
       }

       printf("%i\n",ans);
       if (t > 0)
           puts("");
   }
}
