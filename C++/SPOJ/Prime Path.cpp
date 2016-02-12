#include<iostream>
#include<string>
#include<cstring>
#include<sstream>
#include<string.h>
#include<algorithm>
#include<cmath>
#include<fstream>
#include<cstdlib>
#include<vector>
#include<stdlib.h>
#include<set>
#include<queue>
#define toInt(x) {atoi(x.c_str())};
#define SSTR( x ) dynamic_cast< std::ostringstream & >( \
       ( std::ostringstream() << std::dec << x ) ).str()

using namespace std;
int main()
{
   bool prime[10000];
   for(int k = 0; k < 10000; k++)
       prime[k] = false;

   for(long int i = 2; i*i < 10000; i++)
   {
       if (!prime[i])
       {
           for(long int j = i*i; j < 10000; j += i)
               prime[j] = true;
       }
   }

   int t;
   scanf("%i",&t);

   while(t-->0)
   {
       int dist[10005];
       for(int i = 1000; i < 10000; i++)
           dist[i] = -1;


       string n1,n2;
       cin >> n1 >> n2;

       queue<string> q;
       q.push(n1);
       int num1 = toInt(n1);
       dist[num1] = 0;

       while(!q.empty())
       {
           string parent = q.front();
           q.pop();
           int numParent = toInt(parent);
           if (parent.compare(n2) == 0)
           {
               cout << dist[numParent] << endl;
               break;
           }
           for(int i = 0; i < 4; i++)
           {
               for(int j = 0; j < 10; j++)
               {
                   string child = parent;

                   string tmp = SSTR(j);
                   child[i] = tmp[0];
                   int ch = toInt(child);
                   if (dist[ch] == -1 && !prime[ch])
                   {
                       dist[ch] = dist[numParent]+1;
                       q.push(child);
                   }
               }
           }
       }
   }
}
