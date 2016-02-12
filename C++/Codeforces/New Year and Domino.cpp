#include <bits/stdc++.h>

using namespace std;

int main()
{
   int h, w;
   scanf("%i %i",&h, &w);

   char arr[h][w];
   for(int i = 0; i < h; i++)
   {
       string line;
       cin >> line;
       for(int j = 0; j < w; j++)
           arr[i][j] = line[j];
   }

   long long cummulative[h][w];
   for(int i = 0; i < h; i++)
   {
       for(int j = 0; j < w; j++)
       {
           long long sum = 0;
           if (i > 0)
               sum += cummulative[i-1][j];
           if (j > 0)
               sum += cummulative[i][j-1];
           if (i > 0 && j > 0)
               sum -= cummulative[i-1][j-1];

           if (arr[i][j] != '#')
           {
               if (i > 0 && arr[i-1][j] != '#')
                   sum++;
               if (j > 0 && arr[i][j-1] != '#')
                   sum++;
           }

           cummulative[i][j] = sum;
       }
   }

   int q;
   scanf("%i",&q);

   while(q--)
   {
       int r1, c1, r2, c2;
       scanf("%i %i %i %i",&r1, &c1, &r2, &c2);
       r1--;
       r2--;
       c1--;
       c2--;

       long long ans = cummulative[r2][c2];
       if (r1 > 0)
           ans -= cummulative[r1-1][c2];
       if (c1 > 0)
           ans -= cummulative[r2][c1-1];
       if (r1 > 0 && c1 > 0)
           ans += cummulative[r1-1][c1-1];

       if (r1 > 0)
       {
           for(int j = c1; j <= c2; j++)
           {
               if (arr[r1][j] == '.' && arr[r1-1][j] == '.')
                   ans--;
           }
       }

       if (c1 > 0)
       {
           for(int i = r1; i <= r2; i++)
           {
               if (arr[i][c1] == '.' && arr[i][c1-1] == '.')
                   ans--;
           }
       }

       printf("%I64d\n",ans);
   }
}
