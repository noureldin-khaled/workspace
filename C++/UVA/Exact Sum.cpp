#include <bits/stdc++.h>

using namespace std;

int main()
{
   int n;
   int t = 1;
   while(scanf("%i",&n) != EOF)
   {
       if (t != 1)
           puts("");

//        int n = atoi(s.c_str());

       int arr[n];
       for(int i = 0; i < n; i++)
           scanf("%i",&arr[i]);


       int m;
       scanf("%i",&m);

       sort(arr,arr+n);

       int ans1 = -1;
       int ans2 = -1;
       for(int i = 0; i < n; i++)
       {
           bool found = false;
           int key = m-arr[i];
           int low = 0;
           int high = n-1;

           while(low <= high)
           {
               int mid = low + (high-low)/2;
               if (arr[mid] == key)
               {
                   if (mid == i)
                   {
                       if ((mid < n-1 && arr[mid+1] == key) || (mid > 0 && arr[mid-1] == key))
                           found = true;
                       break;
                   }
                   
                   else
                   {
                       found = true;
                       break;
                   }

               }
               else if (arr[mid] < key)
                   low = mid+1;
               else
                   high = mid-1;
           }

           if (found && ((ans1 == -1 && ans2 == -1) || (abs(m - 2*arr[i]) < abs(ans2-ans1))))
           {
               ans1 = arr[i];
               ans2 = m-arr[i];
           }
       }
       int small = min(ans1,ans2);
       int large = max(ans1,ans2);


       printf("Peter should buy books whose prices are %i and %i.\n",small,large);
       t++;
   }
   puts("");
}
