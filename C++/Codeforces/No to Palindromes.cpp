#include <bits/stdc++.h>

using namespace std;

string s;
int p;

bool can(int index);
bool isValid(int index);
int main()
{
   int n;
   scanf("%i %i",&n, &p);

   cin >> s;

   if (can(n-1))
       cout << s << endl;
   else
       cout << "NO" << endl;
}

bool can(int index)
{
   if (index < 0)
       return false;
   bool valid = false;
   int num = s[index] - 'a';
   for (int i = num+1; i < p && !valid; i++)
   {
       char c = i+'a';
       s[index] = c;
       if (isValid(index))
           valid = true;
   }

   if (valid)
       return true;
   else
   {
       if (!can(index-1))
           return false;

       valid = false;
       for (int i = 0; i < p && !valid; i++)
       {
           char c = i+'a';
           s[index] = c;
           if (isValid(index))
               valid = true;
       }

       return valid;
   }
}

bool isValid(int index)
{
   if (index == 0)
       return true;
   if (index == 1 && s[index] != s[index-1])
       return true;

   if (s[index] != s[index-1] && s[index] != s[index-2])
       return true;
   return false;
}
