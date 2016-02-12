#include <bits/stdc++.h>
#define MAX 200

using namespace std;

int grid[MAX][MAX];
bool visited[MAX][MAX];
int counter[MAX][MAX];
int r, c, m, n;
const int dx[4] = {1,1,-1,-1};
const int dy[4] = {1,-1,1,-1};

void dfs(int i, int j);
bool valid(int i,int j);
int main()
{
   int t;
   scanf("%i",&t);

   for(int k = 1; k <= t; k++)
   {
       for(int i = 0; i < MAX; i++)
           for(int j = 0; j < MAX; j++)
           {
               grid[i][j] = 0;
               counter[i][j] = 0;
               visited[i][j] = false;
           }

       scanf("%i %i %i %i",&r,&c,&m,&n);

       int w;
       scanf("%i",&w);

       for(int i = 0; i < w; i++)
       {
           int a, b;
           scanf("%i %i",&a, &b);
           grid[a][b] = -1;
       }

       dfs(0, 0);

       int countEven = 0;
       int countOdd = 0;
       for (int i = 0; i < r; i++)
           for (int j = 0; j < c; j++)
               if (visited[i][j])
               {
                   if (counter[i][j]%2 == 0)
                       countEven++;
                   else
                       countOdd++;
               }

       printf("Case %i: %i %i\n",k, countEven, countOdd);
   }

}

void dfs(int i, int j)
{
   visited[i][j] = true;

   set<pair<int, int> > s;
   for (int k = 0; k < 4; k++)
   {
       int newI = i + m*dx[k];
       int newJ = j + n*dy[k];

       if (valid(newI, newJ) && s.find(make_pair(newI, newJ)) == s.end())
       {
           s.insert(make_pair(newI, newJ));
           counter[i][j]++;
           if (!visited[newI][newJ])
               dfs(newI, newJ);
       }

       newI = i + n*dx[k];
       newJ = j + m*dy[k];

       if (valid(newI, newJ)  && s.find(make_pair(newI, newJ)) == s.end())
       {
           s.insert(make_pair(newI, newJ));
           counter[i][j]++;
           if (!visited[newI][newJ])
               dfs(newI, newJ);
       }
   }
}

bool valid(int i,int j)
{
   return i >= 0 && i < r && j >= 0 && j < c && grid[i][j] != -1;
}
