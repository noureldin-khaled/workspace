#include <bits/stdc++.h>

using namespace std;

int main()
{
   int n;
   scanf("%i",&n);

   vector<pair<int,int> > v;
   int curElement = -1;
   for(int i = 0; i < n; i++)
   {
       int a;
       scanf("%i",&a);

       if (curElement == -1)
           v.push_back(make_pair(a,1));
       else
       {
           if (curElement == a)
               v.back().second++;
           else
               v.push_back(make_pair(a,1));
       }

       curElement = a;
   }

   int maxIndex = 0;
   int minIndex = 0;
   int maximum = v[0].second;
   int cur = v[0].second;
   for(int i = 1; i < v.size(); i++)
   {
       if (v[i].first > v[maxIndex].first)
       {
           maxIndex = i;
           if (v[maxIndex].first - v[minIndex].first > 1)
           {
               cur = v[maxIndex].second;
               if (abs(v[maxIndex].first - v[maxIndex-1].first) <= 1)
               {
                   cur += v[maxIndex-1].second;
                   minIndex = maxIndex-1;
               }
               else
                   minIndex = maxIndex;
           }
           else
               cur += v[i].second;
       }
       else if (v[i].first < v[minIndex].first)
       {
           minIndex = i;
           if (v[maxIndex].first - v[minIndex].first > 1)
           {
               cur = v[minIndex].second;
               if (abs(v[minIndex-1].first - v[minIndex].first) <= 1)
               {
                   cur += v[minIndex-1].second;
                   maxIndex = minIndex-1;
               }
               else
                   maxIndex = minIndex;
           }
           else
               cur += v[i].second;
       }
       else
           cur += v[i].second;

       maximum = max(cur,maximum);
   }
   printf("%i",maximum);
}
