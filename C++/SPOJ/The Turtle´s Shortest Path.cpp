#include<iostream>
#include<string>
#include<cstring>
#include<sstream>
#include<string.h>
#include<algorithm>
#include<cmath>
#include<cstdlib>
#include<vector>
#include<stdlib.h>
#include<set>
#include<stdio.h>
#include<map>
#include<queue>

using namespace std;

int main()
{
    int t;
    scanf("%i",&t);

    while(t--)
    {
        int n;
        scanf("%i",&n);

        int count = 0;
        map<string, int> map;
        vector<pair <int, int> > graph[n];

        for(int i = 0; i < n; i++)
        {
            string node;
            cin >> node;

            map[node] = count;
            int m;
            scanf("%i",&m);
            for(int j = 0; j < m; j++)
            {
                int dest,weight;
                scanf("%i %i",&dest,&weight);
                dest--;

                graph[count].push_back(make_pair(weight,dest));
            }
            count++;
        }

        int p;
        scanf("%i",&p);
        while(p--)
        {
            string s,e;
            cin >> s >> e;

            int start = map.find(s)->second;
            int end = map.find(e)->second;

            int dist[n];
            memset(dist,-1,sizeof dist);

            priority_queue<pair <int, int> > pq;
            pq.push(make_pair(0,start));
            dist[start] = 0;

            while(!pq.empty())
            {
                pair<int,int> cur = pq.top();
                pq.pop();
                if (cur.first > dist[cur.second])
                    continue;
                for (int i = 0; i < graph[cur.second].size(); i++) {
                    pair<int,int> child = graph[cur.second][i];
                    if (dist[child.second] == -1 || dist[cur.second] + child.first < dist[child.second]) {
                        dist[child.second] = dist[cur.second] + child.first;
                        pq.push(make_pair(dist[child.second], child.second));
                    }
                }
            }
            printf("%d\n",dist[end]);
        }
        if (t > 0)
        {
            string em;
            getline(cin,em);
        }
     }
}
