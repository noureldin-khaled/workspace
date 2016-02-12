#include <bits/stdc++.h>

using namespace std;

int main()
{
   while(true)
   {
       int n, m;
       scanf("%i %i",&n, &m);

       if (n == 0 && m == 0)
           break;

       int arr[n];
       int minimum = -1;
       for(int i = 0; i < n; i++)
       {
           scanf("%i",&arr[i]);
           if (minimum == -1 || arr[i] < minimum)
               minimum = arr[i];
       }

       vector<int> v;
       for(int i = 0; i < m; i++)
       {
           int a;
           scanf("%i",&a);
           v.push_back(a);
       }

       sort(v.begin(), v.end());
       if (minimum > v[m-1] || m < n)
       {
           puts("Loowater is doomed!");
           continue;
       }

       int done = true;
       long long price = 0;
       for(int i = 0; i < n && done; i++)
       {
           int low = 0;
           int high = m-1;
           int ans = -1;

           while(low <= high)
           {
               int mid = low + (high-low)/2;

               if (v[mid] == arr[i])
               {
                   ans = mid;
                   break;
               }
               else if (v[mid] < arr[i])
                   low = mid+1;
               else
               {
                   ans  = mid;
                   high = mid-1;
               }
           }

           if (ans != -1)
           {
               price += v[ans];
               v.erase(v.begin()+ans);
               m--;
           }
           else
           {
               puts("Loowater is doomed!");
               done = false;
               break;
           }
       }
       if (done)
           cout << price << endl;
   }
}
