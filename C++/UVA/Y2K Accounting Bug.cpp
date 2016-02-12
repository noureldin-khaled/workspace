#include <bits/stdc++.h>

using namespace std;

int main()
{
   int s, d;
   while(scanf("%i %i",&s, &d) != EOF)
   {
       long long maxSurplus = -1;
       for(int i = 0; i < (1 << 12); i++)
       {
           bool valid = true;

           for(int j = 0; j <= 7 && valid; j++)
           {
               long long cur = 0;
               for(int k = j; k < j+5; k++)
               {
                   if ((i & (1 << k)) == 0)
                       cur += s;
                   else
                       cur -= d;
               }
               if (cur >= 0)
                   valid = false;
           }

           if (valid)
           {
               long long cur = 0;
               for (int j = 0; j < 12; j++)
               {
                   if ((i & (1 << j)) == 0) //surplus
                       cur += s;
                   else // deficit
                       cur -= d;
               }
               maxSurplus = max(maxSurplus, cur);
           }
       }

       if (maxSurplus == -1)
           puts("Deficit");
       else
           cout << maxSurplus << endl;
   }
}
