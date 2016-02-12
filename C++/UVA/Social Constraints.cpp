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

       pair<pair<int,int> , int > cons[m];
       for(int i = 0; i < m; i++)
       {
           int a, b, c;
           scanf("%i %i %i",&a, &b, &c);
           cons[i] = make_pair(make_pair(a,b),c);
       }

       int arr[n];
       for(int i = 0; i < n; i++)
           arr[i] = i;

       int ans = 0;
       do
       {
           int people[n];
           for(int i = 0; i < n; i++)
               people[arr[i]] = i;

           bool valid = true;
           for(int i = 0; i < m && valid; i++)
           {
               int diff = abs(people[cons[i].first.first] - people[cons[i].first.second]);
               if ((cons[i].second > 0 && diff-1 < cons[i].second) || (cons[i].second < 0 && diff >= abs(cons[i].second)))
                   continue;
               else
                   valid = false;
           }
           if (valid)
               ans++;
       }while(next_permutation(arr, arr+n));

       printf("%i\n",ans);
   }
}
