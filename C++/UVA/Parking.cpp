#include <bits/stdc++.h>

using namespace std;

int main()
{
   int t;
   scanf("%i",&t);

   while(t--)
   {
       int n;
       scanf("%i",&n);
       int arr[n];

       for(int i = 0; i < n; i++)
           scanf("%i",&arr[i]);

       sort(arr,arr+n);

       int ans = 0;
       for(int i = 0; i < n-1; i++)
           ans += (arr[i+1]-arr[i]);

       printf("%i\n",ans*2);
   }
}
