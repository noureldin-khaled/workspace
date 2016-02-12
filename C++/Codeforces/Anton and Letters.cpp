#include <iostream>
#include <string>
#include <cstring>
#include <cstdlib>

using namespace std;

bool contain(string s,char c);
int main()
{
   string s;
   getline(cin,s);

   if (s != "{}"){
       string visited = "";
       int counter = 0;
       for(int i = 1; i < s.length(); i+=3){
           if (!contain(visited,s[i])){
               visited += s[i];
               counter++;
           }
       }
       cout << counter << endl;
   }
   else
       cout << 0 << endl;
}

bool contain(string s,char c){
   for(int i = 0; i < s.length(); i++)
       if (s[i] == c)
           return true;

   return false;
}
