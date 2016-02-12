#include<iostream>
#include<string>
#include<cstring>
#include<sstream>
#include<string.h>
#include<algorithm>
#include<cmath>
#include<cstdlib>
#include<vector>
#include<stdlib.h>
#include<set>
#include<stdio.h>

using namespace std;

int main()
{
   int t;
   scanf("%i",&t);

   while(t--)
   {
       int n,m;
       scanf("%d %d",&n,&m);

       int r = sqrt(m);
       if (r < n) {

       bool arr[r+1];
       for(int k = 0; k <= r; k++)
           arr[k] = false;

       for(long int i = 2; i*i <= r; i++)
       {
           if (!arr[i])
           {
               for(long int j = i*i; j <= r; j += i)
                   arr[j] = true;
           }
       }
       bool res[m-n+1];
       for(int i = 0; i < m-n+1; i++)
           res[i] = false;
       for(long int i = 2; i <= r; i++)
       {
           if (!arr[i])
           {
               int l = (n/i)*i;
               if (l < n)
                   l += i;
               for(;l <= m; l+=i)
               {
                   res[l-n] = true;
               }
           }
       }
       for(int i = 0; i < m-n+1; i++)
           if (!res[i])
               printf("%d\n",i+n);
       }
       else
       {
           bool arr[m+1];
           for(int k = 0; k <= m; k++)
           arr[k] = false;

       for(long int i = 2; i*i <= m; i++)
       {
           if (!arr[i])
           {
               for(long int j = i*i; j <= m; j += i)
                   arr[j] = true;
           }
       }
       arr[0] = arr[1] = true;
       for(int i = n; i <= m; i++)
           if (!arr[i])
               printf("%d\n",i);
       }

       puts("");
   }
}
