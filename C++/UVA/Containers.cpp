#include <bits/stdc++.h>

using namespace std;

int main()
{
   int t = 1;
   while(true)
   {
       string s;
       cin >> s;
       if (s.compare("end") == 0)
           break;

       int ans = 0;
       char arr[1005];
       memset(arr, '!', sizeof arr);
       for(int i = 0; i < s.length(); i++)
       {
           char c = s[i];
           for(int j = 0; j < 1005; j++)
           {
               if (arr[j] == '!')
               {
                   arr[j] = c;
                   ans++;
                   break;
               }
               else if (c <= arr[j])
               {
                   arr[j] = c;
                   break;
               }
           }
       }

       printf("Case %i: %i\n",t++,ans);
   }
}
