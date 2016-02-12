#include <bits/stdc++.h>

using namespace std;

int main()
{
   while(true)
   {
       int n;
       scanf("%i",&n);
       if (n == 0) break;

       while(true)
       {
           int arr[n];
           scanf("%i",&arr[0]);
           if (arr[0] == 0)
               break;

           for(int i = 1; i < n; i++)
               scanf("%i",&arr[i]);

           stack<int> st;
           int countt = 1;

           bool valid = true;
           for(int i = 0; i < n && valid; i++)
           {
               int required = arr[i];
               bool can_stack = true;
               bool can_count = false;

               if (st.empty() || st.top() != required)
                   can_stack = false;

               if (can_stack)
               {
                   st.pop();
                   continue;
               }

               while(countt <= n)
               {
                   if (countt == required)
                   {
                       can_count = true;
                       countt++;
                       break;
                   }
                   else
                   {
                       st.push(countt);
                       countt++;
                   }
               }

               if (!can_count)
                   valid = false;
           }

           if (valid)
               puts("Yes");
           else
               puts("No");
       }
       puts("");
   }
}
