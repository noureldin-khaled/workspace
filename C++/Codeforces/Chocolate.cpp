#include <bits/stdc++.h>

using namespace std;

int main()
{
   int n;
   scanf("%i",&n);

   int in[n];
   int s = 0;
   vector<int> v;
   for(int i = 0; i < n; i++)
   {
       scanf("%i",&in[i]);
       if (in[i] == 1)
       {
           s++;
           v.push_back(i);
       }
   }

   if (s == 0)
   {
       cout << 0 << endl;
       return 0;
   }

   int arr[s-1];

   for(int i = 0; i < s-1; i++)
       arr[i] = v[i+1]-v[i];

   long long ans = 1;

   for(int i = 0; i < s-1; i++)
       ans *= arr[i];

   cout << ans << endl;
}
