#include <bits/stdc++.h>

using namespace std;

int main()
{
   while(true)
   {
       int n, m;
       scanf("%i %i",&n, &m);

       if (n == 0 && m == 0)
           break;

       bitset<1000000> bs;
       bool conflict = false;
       for(int i = 0; i < n; i++)
       {
           int s, e;
           scanf("%i %i",&s, &e);

           if (!conflict)
           {
               for(; s < e; s++)
               {
                   if (bs[s])
                       conflict = true;
                   else
                       bs[s] = 1;
               }

           }
       }

       for(int i = 0; i < m; i++)
       {
           int s, e, interval;
           scanf("%i %i %i",&s, &e, &interval);

           if (!conflict)
           {
               while(s < 1000000)
               {
                   int st = s;
                   int en = e;
                   for(; st < en && st < 1000000; st++)
                   {
                       if (bs[st])
                           conflict = true;
                       else
                           bs[st] = 1;
                   }
                   s += interval;
                   e += interval;
               }
           }
       }

       if (conflict)
           puts("CONFLICT");
       else
           puts("NO CONFLICT");
   }
}
