#include <bits/stdc++.h>

using namespace std;

int main()
{
   int months[] = {31,29,31,30,31,30,31,31,30,31,30,31};
   int num;
   scanf("%i",&num);

   string junk;
   string s;
   cin >> junk >> s;

   if (s.compare("week") == 0)
   {
       int ans = 48;
       int day = 5;
       for(int i = 0; i < 12; i++)
       {
           if (day == num)
               ans++;
           int mod = months[i]%7;
           for(int j = 1; j < mod; j++)
           {
               day++;
               if (day == 8)
                   day = 1;
               if (day == num)
                   ans++;
           }
           day++;
           if (day == 8)
               day = 1;
       }

       printf("%i",ans);
   }
   else
   {
       int ans = 0;
       for(int i = 0; i < 12; i++)
       {
           if (num <= months[i])
               ans++;
       }
       printf("%i",ans);
   }
}
