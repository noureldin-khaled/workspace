#include <bits/stdc++.h>

using namespace std;

int main()
{
   int n;
   scanf("%i",&n);

   int arr[n];
   for(int i = 0; i < n; i++)
       scanf("%i",&arr[i]);

   int maximum = 0;
   for(int i = 0; i < n; i++)
   {
       int counter = 1;
       for(int j = i+1; j < n; j++)
       {
           if (arr[j] > arr[j-1]) break;
           counter++;
       }

       for(int j = i-1; j >= 0; j--)
       {
           if (arr[j] > arr[j+1]) break;
           counter++;
       }

       maximum = max(counter,maximum);
   }

   printf("%i",maximum);
}
