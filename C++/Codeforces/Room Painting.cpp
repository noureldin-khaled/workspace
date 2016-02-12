#include <bits/stdc++.h>

using namespace std;

int main()
{
   int n, m;
   scanf("%i %i",&n, &m);

   int shop[n];
   int needs[m];
   for (int i = 0; i < n; i++)
       scanf("%i",&shop[i]);

   for (int i = 0; i < m; i++)
       scanf("%i",&needs[i]);

   sort(shop, shop + n);

   long long minimum = 0;
   for (int i = 0; i < m; i++)
   {
       int key = needs[i];
       int low = 0;
       int high = n-1;
       int ans = -1;

       while(low <= high)
       {
           int mid = low + (high-low)/2;

           if (shop[mid] >= key)
           {
               ans = mid;
               high = mid-1;
           }
           else
               low = mid+1;
       }

       minimum += (shop[ans] - key);
   }

   cout << minimum << endl;
}
