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
#include <limits>

using namespace std;

int main()
{
   string s,t;
   cin >> s;
   cin >> t;

   int pos = 1;
   for(int i = 0; i < t.length(); i++)
   {
       if (t[i] == s[pos-1])
           pos++;
   }

   cout << pos << endl;
}
