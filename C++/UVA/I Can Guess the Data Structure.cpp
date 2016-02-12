#include <bits/stdc++.h>

using namespace std;

int main()
{
   int n;
   while(scanf("%i",&n) != EOF)
   {
       stack<int> st;
       queue<int> q;
       priority_queue<int, vector<int> > pq;
       bool is_stack = true;
       bool is_queue = true;
       bool is_pq = true;

       for(int i = 0; i < n; i++)
       {
           int a, b;
           scanf("%i %i",&a, &b);

           if (!is_stack && !is_queue && !is_pq)
               continue;
           if (a == 1)
           {
               st.push(b);
               q.push(b);
               pq.push(b);
           }
           else
           {
               if (st.empty() && q.empty() && pq.empty())
               {
                   is_stack = false;
                   is_queue = false;
                   is_pq = false;
                   continue;
               }

               int st_value = st.top();
               st.pop();
               int q_value = q.front();
               q.pop();
               int pq_value = pq.top();
               pq.pop();

               if (st_value != b)
                   is_stack = false;
               if (q_value != b)
                   is_queue = false;
               if (pq_value != b)
                   is_pq = false;
           }
       }

       if (is_stack && !is_queue && !is_pq)
       {
           puts("stack");
           continue;
       }

       if (!is_stack && is_queue && !is_pq)
       {
           puts("queue");
           continue;
       }

       if (!is_stack && !is_queue && is_pq)
       {
           puts("priority queue");
           continue;
       }

       if (!is_stack && !is_queue && !is_pq)
       {
           puts("impossible");
           continue;
       }

       puts("not sure");
   }
}
