#include <bits/stdc++.h>

using namespace std;

int main()
{
   string s1,s2;
   cin >> s1;
   cin >> s2;

   int occS1[26];
   int occS2[26];
   memset(occS1,0,sizeof occS1);
   memset(occS2,0,sizeof occS2);

   for(int i = 0; i < s1.length(); i++)
       occS1[s1[i]-'a']++;

   for(int i = 0; i < s2.length(); i++)
       occS2[s2[i]-'a']++;

   int ans = 0;
   for(int i = 0; i < 26; i++)
   {
       if (occS2[i] == 0)
           continue;
       if (occS1[i] == 0)
       {
           printf("%i",-1);
           return 0;
       }
       ans += min(occS1[i],occS2[i]);
   }

   printf("%i",ans);
}
