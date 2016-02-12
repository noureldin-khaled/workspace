#include <bits/stdc++.h>
#define MAX 30
#define INF 1000000000

using namespace std;


int adjmat[MAX][MAX];
int p[MAX][MAX];
int nodes[MAX][MAX];

void printPath(int i, int j);
void helper(int i, int j);
int main()
{
   int n, m;
   scanf("%i %i",&n, &m);

   for (int i = 0; i < MAX; i++)
       for (int j = 0; j < MAX; j++)
           adjmat[i][j] = INF;

   for (int i = 0; i < MAX; i++)
       adjmat[i][i] = 0;

   for(int i = 0; i < MAX; i++)
	    for(int j = 0; j < MAX; j++)
           p[i][j] = i;

   for (int i = 0; i < MAX; i++)
       for (int j = 0; j < MAX; j++)
           nodes[i][j] = 0;

   for (int i = 0; i < m; i++)
   {
       char c1, c2;
       cin >> c1 >> c2;

       int u = c1 - 'A';
       int v = c2 - 'A';
       int w;
       scanf("%i",&w);

       adjmat[u][v] = w;
       adjmat[v][u] = w;
   }


   for(int k = 0; k < n; k++)
	    for(int i = 0; i < n; i++)
           for(int j = 0; j < n; j++)
               if(adjmat[i][j] > adjmat[i][k] + adjmat[k][j])
               {
                   adjmat[i][j] = adjmat[i][k] + adjmat[k][j];
                   nodes[i][j] = nodes[i][k] + nodes[k][j] + 1;
                   p[i][j] = p[k][j];
               }
               else if (adjmat[i][j] == adjmat[i][k] + adjmat[k][j]
                   && nodes[i][j] > nodes[i][k] + nodes[k][j] + 1)
                   {
                       nodes[i][j] = nodes[i][k] + nodes[k][j] + 1;
                       p[i][j] = p[k][j];
                   }

   int q;
   scanf("%i",&q);

   while(q--)
   {
       char c1, c2;
       cin >> c1 >> c2;
       int u = c1 - 'A';
       int v = c2 - 'A';

       if (u == v)
           cout << c1 << " " << c2;
       else
           printPath(u, v);
       puts("");
   }
}

void printPath(int i, int j)
{
   if(i!=j) helper(i,p[i][j]);
   char c = ((char) (j+'A'));
   cout << c;
}

void helper(int i, int j)
{
   if(i!=j) helper(i,p[i][j]);
   char c = ((char) (j+'A'));
   cout << c << " ";
}
