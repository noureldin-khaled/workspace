#include <bits/stdc++.h>
#define MAX 200

using namespace std;

int adjmatrix[MAX][MAX];
int parent[MAX];
string names[MAX];

void solve(int u, int v);
int gcd( int a,  int b);
int dfs(int u, int t, int amount);
int main()
{
   ios_base::sync_with_stdio(false);
   for (int i = 0; i < MAX; i++)
       for (int j = 0; j < MAX; j++)
           adjmatrix[i][j] = 0;

   map<string, int> m;
   int c = 0;
   while(true)
   {
       char type;
       cin >> type;
       if (type == '.') break;

       if (type == '!')
       {
           string itema, itemb, unused;
           int a, b;

           cin >> a;
           cin >> itema >> unused;
           cin >> b;
           cin >> itemb;

           map<string, int>::iterator ita = m.find(itema);
           map<string, int>::iterator itb = m.find(itemb);
           int u, v;

           if (ita == m.end())
           {
               m[itema] = c;
               names[c] = itema;
               u = c++;
           }
           else
               u = ita->second;
           if (itb == m.end())
           {
               m[itemb] = c;
               names[c] = itemb;
               v = c++;
           }
           else
               v = itb->second;

           int g = gcd(a, b);
           adjmatrix[u][v] = a/g;
           adjmatrix[v][u] = b/g;
       }
       else
       {
           string itema, itemb, unused;
           cin >> itema >> unused >> itemb;

           map<string, int>::iterator ita = m.find(itema);
           map<string, int>::iterator itb = m.find(itemb);
           int u, v;

           if (ita == m.end())
           {
               m[itema] = c;
               names[c] = itema;
               u = c++;
           }
           else
               u = ita->second;
           if (itb == m.end())
           {
               m[itemb] = c;
               names[c] = itemb;
               v = c++;
           }
           else
               v = itb->second;

           solve(u, v);
       }
   }
}

void solve(int u, int v)
{
   memset(parent, -1, sizeof parent);
   parent[u] = u;
   int v_amount = dfs(u ,v ,1);
   string first = names[u];
   string second = names[v];
   if (v_amount == 0)
       cout << "? " << first << " = ? " << second << endl;
   else
   {
       int u_amount = 1;
       stack<int> s;
       s.push(v);
       while(true)
       {
           int node = s.top();
           s.pop();
           if (parent[node] == node) break;
           s.push(parent[node]);
           u_amount *= adjmatrix[parent[node]][node];
       }

       int g = gcd(u_amount, v_amount);
       cout << u_amount/g << " " << first << " = " << v_amount/g << " " << second << endl;
   }
}

int dfs(int u, int t, int amount)
{
   if (u == t)
       return amount;
   for (int v = 0; v < MAX; v++)
   {
       if (adjmatrix[u][v] > 0 && parent[v] == -1)
       {
           parent[v] = u;
           int ans = dfs(v, t, amount*adjmatrix[v][u]);
           if (ans > 0)
               return ans;
       }
   }
   return 0;
}

int gcd( int a,  int b)
{
   return b == 0 ? a : gcd(b, a % b);
}
