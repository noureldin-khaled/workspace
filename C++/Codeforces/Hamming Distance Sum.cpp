#include <bits/stdc++.h>

using namespace std;

int main()
{
   string s1,s2;
   cin >> s1;
   cin >> s2;

   int len1 = s1.length();
   int len2 = s2.length();

   int diff = len2 - len1 + 1;
   int ones = 0;
   for(int i = 0; i < diff; i++)
       if (s2[i] == '1')
           ones++;

   long long ans = 0;
   for(int i = 0; i < len1; i++)
   {
       if (s1[i] == '0')
           ans += ones;
       else
           ans += (diff-ones);

       if (i != len1-1)
       {
           if (s2[i] == '1')
               ones--;
           if (s2[diff + i] == '1')
               ones++;
       }
   }
   printf("%I64d",ans);
}
