#include <bits/stdc++.h>

using namespace std;

int main()
{
   int n, k;
   scanf("%i %i",&n,&k);

   int arr[n];
   for(int i = 0; i < n; i++)
       arr[i] = i+1;

   int t = n-1;
   bool done = false;

   if (t == k)
   {
       for(int i = 0; i < n; i++)
           printf("%i ",arr[i]);
       return 0;
   }
   if (t < k)
   {
       printf("%i",-1);
       return 0;
   }
   for(int i = 1; i < n; i++)
   {
       if (t == k)
           break;
       if (t-1 == k)
       {
           int temp = arr[0];
           arr[0] = arr[i];
           arr[i] = temp;
           t--;
           break;
       }

       if (i == n-1)
           break;

       int temp = arr[i];
       arr[i] = arr[i+1];
       arr[i+1] = temp;
       i++;
       t -= 2;
   }

   if (t == k)
   {
       for(int i = 0; i < n; i++)
           printf("%i ",arr[i]);
   }
   else
   {
       printf("%i",-1);
   }
}
