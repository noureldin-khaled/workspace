#include <bits/stdc++.h>

using namespace std;

int main()
{
   int n;
   scanf("%i",&n);

   pair<int, int> arr[n];
   for(int i = 0; i < n; i++)
   {
       int a;
       scanf("%i",&a);

       arr[i] = make_pair(a,i+1);
   }
   sort(arr,arr+n);

   long long ans = 0;
   for(int i = 0; i < n-1; i++)
       ans += abs(arr[i].second - arr[i+1].second);

   cout << ans << endl;
}
