#include <bits/stdc++.h>

using namespace std;

int main()
{
   int k;
   priority_queue<pair<int, int> ,vector<pair<int,int> > , greater<pair<int,int> > > pq;
   int p[3005];
   while(true)
   {
       string s;
       cin >> s;
       if (s.compare("#") == 0)
           break;
       int q_id, period;
       scanf("%i %i",&q_id, &period);
       pq.push(make_pair(period, q_id));
       p[q_id] = period;
   }

   scanf("%i",&k);

   if (!pq.empty())
   {
       for(int i = 0; i < k; i++)
       {
           pair<int,int> cur = pq.top();
           pq.pop();
           printf("%i\n",cur.second);
           cur.first += p[cur.second];
           pq.push(cur);
       }
   }
}
