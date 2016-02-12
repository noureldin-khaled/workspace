#include <bits/stdc++.h>

using namespace std;

int main()
{
   int t = 1;
   while(true)
   {
       int k;
       scanf("%i",&k);
       if (k == 0) break;
       if (t != 1)
           puts("");

       int arr[k];
       for(int i = 0; i < k; i++)
           scanf("%i",&arr[i]);

       for(int i = 0; i < k-5; i++)
           for(int j = i+1; j < k-4; j++)
               for(int r = j+1; r < k-3; r++)
                   for(int m = r+1; m < k-2; m++)
                       for(int n = m+1; n < k-1; n++)
                           for(int l = n+1; l < k; l++)
                               printf("%i %i %i %i %i %i\n",arr[i],arr[j],arr[r],arr[m],arr[n],arr[l]);
       t++;
   }
}
