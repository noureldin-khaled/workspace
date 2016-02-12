#include <bits/stdc++.h>

using namespace std;

int main()
{
   while(true)
   {
       int n;
       scanf("%i",&n);

       if (n == 0)
           break;
       priority_queue<int, vector<int>, greater<int> > pq;
       for(int i = 0; i < n; i++)
       {
           int a;
           scanf("%i",&a);
           pq.push(a);
       }

       long long ans = 0;
       int s = n;
       while(s > 1)
       {
           int v1 = pq.top();
           pq.pop();
           int v2 = pq.top();
           pq.pop();

           int newV = v1+v2;
           ans += newV;
           pq.push(newV);

           s = pq.size();
       }
       cout << ans << endl;
   }
}
