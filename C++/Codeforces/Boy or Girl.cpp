#include <iostream>
#include <string>

using namespace std;

bool contain(string s,char c);
int main()
{
   string line;
   cin >> line;

   string res = "";
   for(int i = 0; i < line.length(); i++){
       if (!contain(res,line[i]))
           res += line[i];
   }

   if (res.length() % 2 == 0)
       cout << "CHAT WITH HER!" << endl;
   else
       cout << "IGNORE HIM!" << endl;
}

bool contain(string s,char c){
   for(int i = 0; i < s.length(); i++)
       if (s[i] == c)
           return true;

   return false;
}
