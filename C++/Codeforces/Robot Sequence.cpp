#include <bits/stdc++.h>

using namespace std;

bool valid(int i, int j);
string line;
int main()
{
   int n;
   scanf("%i",&n);

   cin >> line;

   int ans = 0;
   for (int i = 0; i < n; i++)
   {
       for (int j = i+1; j < n; j++)
       {
           if (valid(i, j))
               ans++;
       }
   }

   printf("%i",ans);
}

bool valid(int i, int j)
{
   int x = 0;
   int y = 0;
   for (; i <= j; i++)
   {
       if (line[i] == 'U')
           y++;
       else if (line[i] == 'R')
           x++;
       else if (line[i] == 'L')
           x--;
       else
           y--;

   }
   return x == 0 && y == 0;
}
