#include <bits/stdc++.h>
#define MAX 130
#define INF 1000000000

using namespace std;

int main()
{
   int c = 1;
   while(true)
   {
       int adjmat[MAX][MAX];

       for (int i = 0; i < MAX; i++)
           for (int j = 0; j < MAX; j++)
               adjmat[i][j] = INF;

       for (int i = 0; i < MAX; i++)
           adjmat[i][i] = 0;

       map<int, int> m;
       int f, s;
       scanf("%i %i",&f, &s);
       if (f == 0 && s == 0) break;

       m[f] = 0;
       m[s] = 1;
       adjmat[0][1] = 1;
       int n = 2;
       while(true)
       {
           int first, second;
           scanf("%i %i",&first, &second);
           if (first == 0 && second == 0) break;

           int u, v;
           map<int, int>::iterator it_first = m.find(first);
           map<int, int>::iterator it_second = m.find(second);

           if (it_first == m.end())
           {
               m[first] = n;
               u = n++;
           }
           else
               u = it_first->second;

           if (it_second == m.end())
           {
               m[second] = n;
               v = n++;
           }
           else
               v = it_second->second;

           adjmat[u][v] = 1;
       }

       for (int k = 0; k < n; k++)
           for (int i = 0; i < n; i++)
               for (int j = 0; j < n; j++)
                   if (adjmat[i][j] > adjmat[i][k] + adjmat[k][j])
                       adjmat[i][j] = adjmat[i][k] + adjmat[k][j];

       int total = n*(n-1);
       int sum = 0;
       for (int i = 0; i < n; i++)
       {
           for (int j = 0; j < n; j++)
           {
               if (i == j) continue;
               sum += adjmat[i][j];
           }
       }

       double ans = (double)sum/total;
       printf("Case %i: average length between pages = %.3f clicks\n",c++, ans);
   }
}
