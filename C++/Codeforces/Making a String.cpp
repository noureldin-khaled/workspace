#include <bits/stdc++.h>

using namespace std;

int main()
{
   int n;
   scanf("%i",&n);

   priority_queue<int> pq;
   for (int i = 0; i < n; i++)
   {
       int a;
       scanf("%i",&a);

       pq.push(a);
   }

   set<int> s;

   long long ans = 0;
   while(!pq.empty())
   {
       int num = pq.top();
       pq.pop();
       if (s.find(num) == s.end())
       {
           ans += num;
           s.insert(num);
       }
       else
       {
           num--;
           if (num > 0)
               pq.push(num);
       }
   }

   cout << ans << endl;
}
