#include <bits/stdc++.h>
#define INF 10005

using namespace std;

int main()
{
   int n,x0,y0;
   scanf("%i %i %i",&n,&x0,&y0);

   pair<int,int> arr[n];
   for(int i = 0; i < n; i++)
   {
       int x,y;
       scanf("%i %i",&x,&y);

       arr[i] = make_pair(x,y);
   }

   int ans = 0;
   for(int i = 0; i < n; i++)
   {
       if (arr[i].first != INF && arr[i].second != INF)
       {
           ans++;
           for(int j = i+1; j < n; j++)
           {
               if ((arr[i].first - x0)*(arr[j].second - y0) == (arr[i].second - y0)*(arr[j].first - x0))
                   arr[j].first = arr[j].second = INF;
           }
           arr[i].first = arr[i].second = INF;
       }
   }
   printf("%i",ans);
}
