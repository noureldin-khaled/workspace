#include <bits/stdc++.h>

using namespace std;

int main()
{
   int n;
   scanf("%i",&n);
   int counter = 0;
   string out = "";

   while(counter <= n)
   {
       out += "abcd";
       counter += 4;
   }

   for(int i = 0; i < n; i++)
       printf("%c",out[i]);

}
