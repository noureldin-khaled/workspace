#include <bits/stdc++.h>

using namespace std;

int main()
{
   int n;
   scanf("%i",&n);

   int arr[n];
   long long sum = 0;
   for(int i = 0; i < n; i++)
   {
       scanf("%i",&arr[i]);
       sum += arr[i];
   }

   sort(arr, arr+n);
   reverse(arr,arr+n);
   long long median = sum/n;
   long long ans = 0;

   for(int i = 0; i < n; i++)
   {
       if (i < sum%n)
           ans += abs(median+1-arr[i]);
       else
           ans += abs(median-arr[i]);
   }
   ans /= 2;

   cout << ans << endl;
}
