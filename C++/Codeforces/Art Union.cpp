#include <bits/stdc++.h>

using namespace std;

int main()
{
   int m, n;
   scanf("%i %i",&m, &n);

   int arr[m][n];
   for(int i = 0; i < m; i++)
       for(int j = 0; j < n; j++)
           scanf("%i",&arr[i][j]);

   int time[m][n];

   int sum = 0;
   for(int i = 0; i < m; i++)
   {
       sum += arr[i][0];
       time[i][0] = sum;
   }

   for(int i = 1; i < n; i++)
   {
       for(int j = 0; j < m; j++)
       {
           if (j == 0)
               time[j][i] = time[j][i-1] + arr[j][i];
           else
           {
               time[j][i] = time[j-1][i];
               if (time[j][i] < time[j][i-1])
                   time[j][i] += (time[j][i-1]-time[j][i]);
               time[j][i] += arr[j][i];
           }
       }
   }

   for(int j = 0; j < m; j++)
       printf("%i ",time[j][n-1]);
}
