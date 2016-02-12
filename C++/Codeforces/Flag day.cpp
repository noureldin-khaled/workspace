#include <bits/stdc++.h>

using namespace std;

int main(){
   int n, m;
   scanf("%d %d", &n, &m);

   int arr[n];
   memset(arr,0,sizeof arr);

   for(int i = 0; i < m; i++)
   {
       int a,b,c;
       scanf("%d %d %d",&a, &b, &c);
       a--;
       b--;
       c--;
       if (arr[a] == 0 && arr[b] == 0 && arr[c] == 0)
       {
           arr[a] = 1;
           arr[b] = 2;
           arr[c] = 3;
       }
       else if (arr[a] != 0)
       {
           if (arr[a] == 1)
           {
               arr[b] = 2;
               arr[c] = 3;
           }
           else if (arr[a] == 2)
           {
               arr[b] = 1;
               arr[c] = 3;
           }
           else
           {
               arr[b] = 1;
               arr[c] = 2;
           }
       }
       else if (arr[b] != 0)
       {
           if (arr[b] == 1)
           {
               arr[a] = 2;
               arr[c] = 3;
           }
           else if (arr[b] == 2)
           {
               arr[a] = 1;
               arr[c] = 3;
           }
           else
           {
               arr[a] = 1;
               arr[c] = 2;
           }
       }
       else
       {
           if (arr[c] == 1)
           {
               arr[b] = 2;
               arr[a] = 3;
           }
           else if (arr[c] == 2)
           {
               arr[b] = 1;
               arr[a] = 3;
           }
           else
           {
               arr[b] = 1;
               arr[a] = 2;
           }
       }
   }

   for(int i = 0; i < n; i++)
       printf("%d ",arr[i]);
}
