#include <bits/stdc++.h>

using namespace std;

int main()
{
   int t;
   scanf("%i",&t);
   while(t--)
   {
       int b, sg, sb;
       scanf("%i %i %i",&b, &sg, &sb);

       priority_queue<int, vector<int> > pq_green;
       priority_queue<int, vector<int> > pq_blue;

       for(int i = 0; i < sg; i++)
       {
           int a;
           scanf("%i",&a);
           pq_green.push(a);
       }

       for(int i = 0; i < sb; i++)
       {
           int a;
           scanf("%i",&a);
           pq_blue.push(a);
       }

       while(!pq_green.empty() && !pq_blue.empty())
       {
           vector<int> temp_green;
           vector<int> temp_blue;

           for(int k = 0; k < b && !pq_green.empty() && !pq_blue.empty(); k++)
           {
               int green_soldier = pq_green.top();
               pq_green.pop();

               int blue_soldier = pq_blue.top();
               pq_blue.pop();

               temp_green.push_back(green_soldier);
               temp_blue.push_back(blue_soldier);
           }

           for(int k = 0; k < temp_green.size(); k++)
           {
               int green = temp_green[k];
               int blue = temp_blue[k];

               if (green > blue)
                   pq_green.push(green - blue);
               else if (blue > green)
                   pq_blue.push(blue - green);
           }
       }

       if (pq_green.empty() && pq_blue.empty())
           puts("green and blue died");
       else if (pq_green.empty()) // blue won
       {
           puts("blue wins");
           while(!pq_blue.empty())
           {
               printf("%i\n",pq_blue.top());
               pq_blue.pop();
           }
       }
       else // green won
       {
           puts("green wins");
           while(!pq_green.empty())
           {
               printf("%i\n",pq_green.top());
               pq_green.pop();
           }
       }
       if (t > 0)
           puts("");
   }
}
