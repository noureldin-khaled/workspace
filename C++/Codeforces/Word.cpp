#include<iostream>
#include<string>
#include<cstring>
#include<sstream>
#include<string.h>
#include<algorithm>
#include<cmath>
#include<cstdlib>
#include<vector>
#include<stdlib.h>
#include<set>
#include<stdio.h>

using namespace std;

int main()
{
   string word;
   cin >> word;

   int low = 0;
   int high = 0;
   int length = word.length();
   for(int i = 0; i < length; i++)
   {
       if (islower(word[i]))
           low++;
       else
           high++;
   }

   string res = "";
   if (low >= high)
   {
       for(int i = 0; i < length; i++)
           res += (char)tolower(word[i]);

   }
   else
   {
       for(int i = 0; i < length; i++)
           res += (char)toupper(word[i]);
   }

   cout << res << endl;
}
