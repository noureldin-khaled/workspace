#include <bits/stdc++.h>

using namespace std;

int main()
{
   int test;
   scanf("%i",&test);
   for (int c = 1; c <= test; c++)
   {
       int n, m, s, t;
       scanf("%i %i %i %i",&n, &m, &s, &t);

       vector<pair<int, int> > adjlist[n];

       for (int i = 0; i < m; i++)
       {
           int u, v, w;
           scanf("%i %i %i",&u, &v, &w);

           adjlist[u].push_back(make_pair(w, v));
           adjlist[v].push_back(make_pair(w, u));
       }

       int dist[n];

       for (int i = 0; i < n; i++)
           dist[i] = -1;

       priority_queue<pair<int, int> , vector<pair<int, int> >, greater<pair<int, int> > > pq;
       dist[s] = 0;
       pq.push(make_pair(0, s));

       while(!pq.empty())
       {
           pair<int, int> cur = pq.top();
           pq.pop();
           if (cur.second == t)
               break;
           if (cur.first > dist[cur.second])
               continue;
           for (int i = 0; i < adjlist[cur.second].size(); i++)
           {
               pair<int, int> nxt = adjlist[cur.second][i];
               if (dist[nxt.second] == -1 || cur.first + nxt.first < dist[nxt.second])
               {
                   dist[nxt.second] = cur.first + nxt.first;
                   pq.push(make_pair(dist[nxt.second], nxt.second));
               }
           }
       }

       printf("Case #%i: ",c);
       if (dist[t] == -1)
           printf("unreachable\n");
       else
           printf("%i\n",dist[t]);
   }
}
