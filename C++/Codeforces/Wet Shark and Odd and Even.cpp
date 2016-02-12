#include <bits/stdc++.h>

using namespace std;

int main()
{
   int n;
   scanf("%i",&n);

   long long ans = 0;

   vector<int> v;
   for (int i = 0; i < n; i++)
   {
       int num;
       scanf("%i",&num);
       if (num%2 == 0)
           ans += num;
       else
           v.push_back(num);
   }

   sort(v.begin(), v.end());

   int s = v.size();
   int index = 0;
   if (s%2 != 0)
       index++;
   for (; index < s; index++)
       ans += v[index];

   cout << ans << endl;
}
