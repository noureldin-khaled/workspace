#include <bits/stdc++.h>

using namespace std;

int main()
{
   int n;
   scanf("%i",&n);
   string num;
   cin >> num;

   int occ[10];
   memset(occ, 0, sizeof occ);
   for (int i = 0; i < n; i++)
   {
       int digit = num[i] - '0';
       for(; digit >= 2; digit--)
           occ[digit]++;
   }

   occ[3] += 2 * occ[9];
   occ[9] = 0;
   occ[4] += occ[8];
   occ[2] += occ[8];
   occ[8] = 0;
   if (occ[6] > occ[7])
   {
       occ[2] += (occ[6] - occ[7]);
       occ[3] += (occ[6] - occ[7]);
       occ[6] = occ[7];
   }

   if (occ[4] > occ[5])
   {
       occ[2] += (occ[4] - occ[5]);
       occ[2] += (occ[4] - occ[5]);
       occ[4] = occ[5];
   }

   string ans = "";
   for(int i = 9; i >= 2; i--)
   {
       if (occ[i] == 0) continue;
       occ[i] -= ans.length();
       for(int j = 0; j < occ[i]; j++)
           ans += i + '0';
   }

   cout << ans << endl;
}
