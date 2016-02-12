#include <bits/stdc++.h>

using namespace std;

int main()
{
   int n;
   scanf("%i",&n);

   int arr[n];
   for(int i = 0; i < n; i++)
       scanf("%i",&arr[i]);

   string s;
   cin >> s;

   bool m[n];

   for(int i = 0; i < n; i++)
   {
       if (s[i] == '1')
           m[i] = true;
       else
           m[i] = false;
   }

   int comm[n];
   comm[0] = arr[0];
   for(int i = 1; i < n; i++)
       comm[i] = comm[i-1] + arr[i];


   int right_sum = 0;
   int ans = 0;
   for(int i = n-1; i >= 0; i--)
   {
       if (m[i])
       {
           int cur = comm[0];
           if (i != 0)
               cur = comm[i-1];
           cur += right_sum;
           ans = max(ans, cur);
           right_sum += arr[i];
       }
   }

   printf("%i",ans);

}
