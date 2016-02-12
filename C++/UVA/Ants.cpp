#include <bits/stdc++.h>

using namespace std;

int main()
{
   int t;
   scanf("%i",&t);

   while(t--)
   {
       int l, n;
       scanf("%i %i",&l,&n);

       int arr[n];
       for(int i = 0; i < n; i++)
           scanf("%i",&arr[i]);

       sort(arr,arr+n);

       int earliest = 0;
       for(int i = 0; i < n; i++)
       {
           int cur = min(arr[i], l-arr[i]);
           earliest = max(earliest, cur);
       }

       int latest = max(l-arr[0],arr[n-1]);

       printf("%i %i\n",earliest, latest);
   }
}
