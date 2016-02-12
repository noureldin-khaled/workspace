#include <bits/stdc++.h>

using namespace std;

int main()
{

   int n;
   while(true)
   {
       scanf("%d",&n);
       if (n == 0)
           break;

       int len = 0;
       long num = 1;
       while(true)
       {
           if (n < num)
               break;

           num *= 2;
           len++;
       }

       int countt = 1;
       int a = 0;
       int b = 0;
       for(int i = 0; i < len; i++)
       {
           if ((n & (1 << i)) != 0)
           {
               if (countt%2 == 0)
                   b |= (1 << i);
               else
                   a |= (1 << i);

               countt++;
           }
       }

       printf("%d %d\n",a,b);
   }


}
