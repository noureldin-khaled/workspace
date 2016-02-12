#include <bits/stdc++.h>

using namespace std;

int main()
{
   map<int, int> m;
   for(int i = 1; i < 4501; i++)
   {
       int p = i*i;
       m[p] = i;
   }

   int t;
   scanf("%i",&t);
   while(t--)
   {
       int n;
       scanf("%i",&n);
       int arr[n];
       memset(arr, -1, sizeof arr);
       bool valid = true;
       int ballNo = 1;
       while(valid)
       {
           valid = false;
           for (int i = 0; i < n && !valid; i++)
           {
               if (arr[i] == -1|| m.find(ballNo+arr[i]) != m.end())
               {
                   arr[i] = ballNo++;
                   valid = true;
               }
           }
       }
       printf("%i\n",ballNo-1);
   }
}
