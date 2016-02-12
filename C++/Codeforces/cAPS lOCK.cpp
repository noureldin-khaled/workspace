#include <iostream>
#include <string>

using namespace std;


int main()
{
  string s;
  cin >> s;

  string res = "";
  if (s[0] >= 'a' && s[0] <= 'z')
       res += toupper(s[0]);
   else
       res += tolower(s[0]);

   bool flag = false;
   for(int i = 1; i < s.length() && !flag; i++){
       if (s[i] >= 'A' && s[i] <= 'Z')
           res += tolower(s[i]);
       else
           flag = true;
   }

   if (flag)
       cout << s << endl;
   else
       cout << res << endl;
}
