#include <bits/stdc++.h>

using namespace std;

int main()
{
   int n;
   scanf("%i",&n);

   int arr[n][n];
   for (int i = 0; i < n; i++)
       for(int j = 0; j < n; j++)
           scanf("%i",&arr[i][j]);

   int res[n];
   memset(res, -1, sizeof res);

   for (int i = 1; i <= n; i++)
   {
       int index = -1;
       for (int r = 0; r < n; r++)
       {
           for (int c = 0; c < n; c++)
           {
               int num = arr[r][c];
               if (num < i)
                   continue;
               if (num == i)
                   index = r;
               else
               {
                   index = -1;
                   break;
               }
           }

           if (index != -1)
           {
               res[index] = i;
               break;
           }
       }
   }

   for (int i = 0; i < n; i++)
   {
       if (res[i] == -1)
           res[i] = n;
       printf("%i ",res[i]);
   }
}
