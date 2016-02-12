#include <bits/stdc++.h>

using namespace std;

int main()
{
   int n, x1, y1, x2, y2;
   scanf("%i %i %i %i %i",&n, &x1, &y1, &x2, &y2);

   pair<long long, long long> dist1[n];
   pair<long long, long long> dist2[n];

   for(int i = 0; i < n; i++)
   {
       int x, y;
       scanf("%i %i",&x, &y);

       long long d1 = (long long)(x-x1)*(x-x1) + (long long)(y-y1)*(y-y1);
       long long d2 = (long long)(x-x2)*(x-x2) + (long long)(y-y2)*(y-y2);
       dist1[i] = make_pair(d1, d2);
       dist2[i] = make_pair(d2, d1);
   }

   sort(dist1, dist1 + n);
   reverse(dist1, dist1 + n);
   sort(dist2, dist2 + n);
   reverse(dist2, dist2 + n);


   long long ans1 = dist1[0].first;
   long long ans2 = dist2[0].first;
   long long curMax1 = dist1[0].second;
   long long curMax2 = dist2[0].second;

   for(int i = 1; i < n; i++)
   {
       ans1 = min(ans1, dist1[i].first + curMax1);
       curMax1 = max(curMax1, dist1[i].second);
   }

   for(int i = 1; i < n; i++)
   {
       ans2 = min(ans2, dist2[i].first + curMax2);
       curMax2 = max(curMax2, dist2[i].second);
   }

   cout << min(ans1, ans2) << endl;
}
