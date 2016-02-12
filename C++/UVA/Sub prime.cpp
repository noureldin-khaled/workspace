#include <bits/stdc++.h>

using namespace std;

int main()
{
   while (true)
   {
       int b, n;
       scanf("%i %i",&b,&n);

       if (b == 0 && n == 0)
           break;
       int arr[b];
       for(int i = 0; i < b; i++)
           scanf("%i",&arr[i]);

       for(int i = 0; i < n; i++)
       {
           int d, c, v;
           scanf("%i %i %i",&d, &c, &v);
           d--;
           c--;
           arr[d] -= v;
           arr[c] += v;
       }

       bool valid = true;
       for(int i = 0; i < b; i++)
       {
           if (arr[i] < 0)
               valid = false;
       }
       if (valid)
           puts("S");
       else
           puts("N");
   }
}
