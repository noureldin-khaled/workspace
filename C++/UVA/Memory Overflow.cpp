#include <bits/stdc++.h>

using namespace std;

int main()
{
   int t;
   scanf("%i",&t);

   for(int c = 1; c <= t; c++)
   {
       int n, k;
       scanf("%i %i",&n, &k);

       string p;
       cin >> p;

       map<char, int> m;

       int ans = 0;
       int day = 1;
       for(int i = 0; i < p.length(); i++)
       {
           map<char, int>::iterator it = m.find(p[i]);
           if (it == m.end())
               m[p[i]] = day;
           else
           {
               if (day-(it->second) <= k)
                   ans++;
               it->second = day;
           }
           day++;
       }

       printf("Case %i: %i\n",c,ans);
   }
}
