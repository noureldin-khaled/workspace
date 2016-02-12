#include <bits/stdc++.h>

using namespace std;

int main()
{
   string s;
   cin >> s;
   int len = s.length();
   if (len%2 == 1)
       puts("No");
   else
   {
       stack<char> st;
       for(int i = 0; i < len; i++)
       {
           if (st.empty() || st.top() != s[i])
               st.push(s[i]);
           else
               st.pop();
       }

       if (st.empty())
           puts("Yes");
       else
           puts("No");
   }
}
