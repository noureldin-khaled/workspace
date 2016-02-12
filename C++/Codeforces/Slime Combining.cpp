#include <bits/stdc++.h>

using namespace std;

int main()
{
   int n;
   scanf("%i",&n);

   stack<int> s;
   s.push(1);
   for (int i = 1; i < n; i++)
   {
       int cur = 1;
       bool done = false;
       while(!done)
       {
           if (cur != s.top())
               done = true;
           else
           {
               cur++;
               s.pop();
               if (s.empty())
                   done = true;
           }

       }
       s.push(cur);
   }
   stack<int> res;
   while(!s.empty())
   {
       int v = s.top();
       s.pop();
       res.push(v);
   }

   while(!res.empty())
   {
       int v = res.top();
       res.pop();
       printf("%i ",v);
   }
}
