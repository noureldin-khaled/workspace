#include <bits/stdc++.h>

using namespace std;

int main()
{
   string s;
   cin >> s;

   int m;
   scanf("%i",&m);
   int len = s.length();
   for(int i = 0; i < m; i++)
   {
       int l,r,k;
       scanf("%i %i %i",&l,&r,&k);
       l--;
       r--;
       k %= r-l+1;
       string temp = "";

       for(int j = 0; j < l; j++)
           temp += s[j];

       for(int j = r-k+1; j <= r; j++)
           temp += s[j];

       for(int j = l; j < r-k+1; j++)
           temp += s[j];

       for(int j = r+1; j < len; j++)
           temp += s[j];
       s = temp;
   }
   cout << s << endl;
}
