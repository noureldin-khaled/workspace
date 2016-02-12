#include <bits/stdc++.h>

using namespace std;

int main()
{
   int n, m;
   scanf("%i",&n);
   scanf("%i",&m);

   int arr[n];
   for(int i = 0; i < n; i++)
       scanf("%i",&arr[i]);

   sort(arr,arr+n);
   reverse(arr,arr+n);

   int ans = 0;
   for(int i = 0; i < n; i++)
   {
       m -= arr[i];
       ans++;
       if (m <= 0) break;
   }

   printf("%i",ans);
}
