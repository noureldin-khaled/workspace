#include <bits/stdc++.h>

using namespace std;

int main()
{
   int n;
   scanf("%i",&n);

   set<int> s;
   int start = 0;
   bool valid = false;
   vector<pair<int, int> > res;
   for(int i = 0; i < n; i++)
   {
       int num;
       scanf("%i",&num);

       if (s.find(num) == s.end())
           s.insert(num);
       else
       {
           valid = true;
           res.push_back(make_pair(start, i));
           start = i+1;
           s.clear();
       }
   }

   if (!valid)
       cout << -1 << endl;
   else
   {
       res.back().second = n-1;
       int si = res.size();
       printf("%i\n",si);
       for(int i = 0; i < si; i++)
           printf("%i %i\n",res[i].first+1, res[i].second+1);
   }
}
