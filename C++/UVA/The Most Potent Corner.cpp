#include <bits/stdc++.h>

using namespace std;

int power(int base,int p)
{
   if (p == 0)
       return 1;
   return base*power(base,p-1);
}

int main()
{
   int n;
   while(scanf("%i",&n) != EOF)
   {
       int p = power(2, n);
       int arr[p];
       for(int i = 0; i < p; i++)
           scanf("%i",&arr[i]);

       int potencies[p];
       memset(potencies, 0, sizeof potencies);

       for(int i = 0; i < p; i++)
       {
           for(int j = 0; j < n; j++)
           {
               int neighbour = i^(1 << j);
               potencies[i] += arr[neighbour];
           }
       }


       int maximum = -1;
       for(int i = 0; i < p; i++)
       {
           for(int j = 0; j < n; j++)
           {
               int neighbour = i^(1 << j);
               int cur = potencies[i] + potencies[neighbour];
               maximum = max(cur, maximum);
           }
       }

       printf("%i\n",maximum);
   }
}
