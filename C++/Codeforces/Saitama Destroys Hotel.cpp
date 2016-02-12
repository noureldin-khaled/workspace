#include <bits/stdc++.h>

using namespace std;

int main()
{
   int n,s;
   scanf("%i %i",&n,&s);

   pair<int,int> arr[n];
   for(int i = 0; i < n; i++)
   {
       int f,t;
       scanf("%i %i",&f,&t);

       arr[i] = make_pair(f,t);
   }
   sort(arr,arr+n);
   reverse(arr,arr+n);

   int time = 0;
   int prev = s;
   for(int i = 0; i < n; i++)
   {
       time += (prev-arr[i].first);
       if (time < arr[i].second)
           time = arr[i].second;
       prev = arr[i].first;
   }
   time += arr[n-1].first;
   printf("%i",time);
}
