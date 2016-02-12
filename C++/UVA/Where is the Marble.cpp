#include <bits/stdc++.h>

using namespace std;

int main()
{
   int c = 1;
   while(true)
   {
       int n, q;
       scanf("%i %i",&n, &q);
       if (n == 0 && q  == 0)
           break;

       int arr[n];
       for(int i = 0; i < n; i++)
           scanf("%i",&arr[i]);

       sort(arr, arr+n);

       printf("CASE# %i:\n",c);
       while(q--)
       {
           int num;
           scanf("%i",&num);

           int low = 0;
           int high = n-1;
           int ans = -1;

           while(low <= high)
           {
               int mid = low + (high-low)/2;
               if (arr[mid] == num)
               {
                   ans = mid;
                   high = mid-1;
               }
               else if (arr[mid] > num)
                   high = mid-1;
               else
                   low = mid+1;
           }

           if (ans == -1)
               printf("%i not found\n", num);
           else
               printf("%i found at %i\n", num,ans+1);
       }
       c++;
   }
}
