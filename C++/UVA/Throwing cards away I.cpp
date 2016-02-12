#include <bits/stdc++.h>

using namespace std;

int main()
{
   while(true)
   {
       int n;
       scanf("%i",&n);
       if (n == 0)
           break;

       queue<int> q;
       for(int i = 1; i <= n; i++)
           q.push(i);

       int s = n;
       vector<int> thrown;
       while(s >= 2)
       {
           thrown.push_back(q.front());
           q.pop();
           q.push(q.front());
           q.pop();
           s = q.size();
       }

       printf("Discarded cards:");
       for(int i = 0; i < thrown.size(); i++)
       {
           if (i != 0)
               printf(",");
           printf(" %i",thrown[i]);
       }

       printf("\nRemaining card: %i\n",q.front());
   }
}
