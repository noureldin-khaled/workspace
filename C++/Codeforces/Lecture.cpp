#include<iostream>
#include<string>
#include<cstring>
#include<sstream>
#include<string.h>
#include<algorithm>
#include<cmath>
#include<math.h>
#include<fstream>
#include<cstdlib>
#include<vector>
#include<stdlib.h>
#include<set>
#include<stdio.h>
#include<limits>

using namespace std;

string smaller(string s1,string s2);
int main()
{
   int n,m;
   scanf("%i %i",&n,&m);

   pair<string, string> arr[m];

   for(int i = 0; i < m; i++)
   {
       string s1,s2;
       cin >> s1 >> s2;
       arr[i] = make_pair(s1,s2);
   }

   vector<string> out;
   for(int i = 0; i < n; i++)
   {
       string s;
       cin >> s;
       for(int j = 0; j < m; j++)
       {
           if (!s.compare(arr[j].first) || !s.compare(arr[j].second))
           {
               out.push_back(smaller(arr[j].first,arr[j].second));
               break;
           }
       }
   }

   for(int i = 0; i < out.size();i++)
       if (i == out.size()-1)
           cout << out[i];
       else
           cout << out[i] << " ";

}

string smaller(string s1,string s2)
{
   return s2.length() < s1.length() ? s2 : s1;
}
