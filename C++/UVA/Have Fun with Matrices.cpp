#include <bits/stdc++.h>

using namespace std;

int main()
{
   int t;
   scanf("%i",&t);

   for(int f = 1; f <= t; f++)
   {
       int n;
       scanf("%i",&n);

       int arr[n][n];
       for(int i = 0; i < n; i++)
       {
           string line;
           cin >> line;
           for(int j = 0; j < n; j++)
           {
               char c = line[j];
               arr[i][j] = c-'0';
           }
       }

       int m;
       scanf("%i",&m);

       for(int i = 0; i < m; i++)
       {
           string command;
           cin >> command;

           if (command.compare("row") == 0)
           {
               int a, b;
               scanf("%i %i",&a, &b);
               a--;
               b--;

               for(int j = 0; j < n; j++)
               {
                   int temp = arr[a][j];
                   arr[a][j] = arr[b][j];
                   arr[b][j] = temp;
               }
           }
           else if (command.compare("col") == 0)
           {
               int a, b;
               scanf("%i %i",&a, &b);
               a--;
               b--;

               for(int j = 0; j < n; j++)
               {
                   int temp = arr[j][a];
                   arr[j][a] = arr[j][b];
                   arr[j][b] = temp;
               }
           }
           else if (command.compare("inc") == 0)
           {
               for(int j = 0; j < n; j++)
                   for(int k = 0; k < n; k++)
                       arr[j][k] = (arr[j][k]+1)%10;
           }
           else if (command.compare("dec") == 0)
           {
               for(int j = 0; j < n; j++)
                   for(int k = 0; k < n; k++)
                       arr[j][k] = ((arr[j][k]-1)%10 + 10)%10;
           }
           else
           {
               for(int j = 0; j < n; j++)
               {
                   for(int k = j; k < n; k++)
                   {
                       int temp = arr[j][k];
                       arr[j][k] = arr[k][j];
                       arr[k][j] = temp;
                   }
               }
           }
       }

       printf("Case #%i\n",f);
       for(int j = 0; j < n; j++)
       {
           for(int k = 0; k < n; k++)
           {
               printf("%i",arr[j][k]);
           }
           puts("");
       }
       puts("");
   }
}
