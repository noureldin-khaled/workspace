#include <bits/stdc++.h>

using namespace std;

int main()
{
   while(true)
   {
       int n;
       scanf("%i",&n);
       if (n == 0)
           break;

       int arr[n];
       for(int i = 0; i < n; i++)
           scanf("%i",&arr[i]);

       int ans = 0;
       for(int i = 0; i < n; i++)
       {
           if (i == 0)
           {
               if ((arr[i] > arr[i+1] && arr[i] > arr[n-1]) || (arr[i] < arr[i+1] && arr[i] < arr[n-1]))
                   ans++;
           }
           else if (i == n-1)
           {
               if ((arr[i] > arr[i-1] && arr[i] > arr[0]) || (arr[i] < arr[i-1] && arr[i] < arr[0]))
                   ans++;
           }
           else
           {
               if ((arr[i] > arr[i-1] && arr[i] > arr[i+1]) || ((arr[i] < arr[i-1] && arr[i] < arr[i+1])))
                   ans++;
           }
       }

       printf("%i\n",ans);
   }
}
