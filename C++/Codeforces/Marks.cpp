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
#include<stdio.h>

using namespace std;

int main()
{
   int n,m;
   scanf("%i %i",&n,&m);

   int grades[n][m];
   for(int i = 0; i < n; i++)
   {
       string s;
       cin >> s;
       for(int j = 0; j < m; j++)
           grades[i][j] = s[j]-'0';

   }

   bool success[n];
   for(int i = 0; i < n; i++)
       success[i] = false;

   for(int j = 0; j < m; j++)
   {
       int maximum = -1;
       vector<int> students;
       for(int i = 0; i < n; i++)
       {
           if (grades[i][j] > maximum)
           {
               students.clear();
               maximum = grades[i][j];
               students.push_back(i);
           }
           else if (grades[i][j] == maximum)
               students.push_back(i);

       }


       for (vector<int>::iterator it = students.begin(); it != students.end(); it++) {
           int element = *it;
           success[element] = true;
       }
   }

   int ans = 0;
   for(int i = 0; i < n; i++)
       if (success[i])
           ans++;

   printf("%i",ans);
}
