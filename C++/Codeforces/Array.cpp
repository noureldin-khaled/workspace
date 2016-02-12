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

using namespace std;

int main()
{
   int n;
   scanf("%i",&n);

   vector<int> pos;
   vector<int> neg;
   vector<int> zero;

   for(int i = 0; i < n; i++)
   {
       int a;
       scanf("%i",&a);

       if (a > 0)
           pos.push_back(a);
       else if (a < 0)
           neg.push_back(a);
       else
           zero.push_back(a);
   }

   if (pos.empty())
   {
       pos.push_back(neg[0]);
       neg.erase(neg.begin());
       pos.push_back(neg[0]);
       neg.erase(neg.begin());
   }

   if (neg.size()%2 == 0) {
       zero.push_back(neg[0]);
       neg.erase(neg.begin());
   }

   printf("%i",neg.size());
   for(int i = 0; i < neg.size();i++)
       printf(" %d",neg[i]);

   printf("\n%i",pos.size());
   for(int i = 0; i < pos.size();i++)
       printf(" %d",pos[i]);

   printf("\n%i",zero.size());
   for(int i = 0; i < zero.size();i++)
       printf(" %d",zero[i]);
}
