#include <bits/stdc++.h>

using namespace std;

int main()
{
   int n;
   scanf("%i",&n);

   int comm[n];
   for(int i = 0; i < n; i++)
   {
       int a;
       scanf("%i",&a);

       if (i == 0)
           comm[i] = a;
       else
           comm[i] = comm[i-1] + a;
   }

   int m;
   scanf("%i",&m);

   for(int i = 0; i < m; i++)
   {
       int q;
       scanf("%i",&q);

       int low = 0;
       int high = n-1;
       int ans = -1;

       while(low <= high)
       {
           int mid = low + (high-low)/2;
           if (comm[mid] >= q)
           {
               ans = mid;
               high = mid-1;
           }
           else
               low = mid+1;
       }

       printf("%i\n",ans+1);
   }
}
