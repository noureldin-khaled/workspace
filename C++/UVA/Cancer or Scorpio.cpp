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
#define toInt(x) {atoi(x.c_str())};
#define SSTR( x ) dynamic_cast< std::ostringstream & >( \
       ( std::ostringstream() << std::dec << x ) ).str()

using namespace std;

string zodiac(int day,int month,int year);
int main()
{
   int months[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

   int n;
   scanf("%i",&n);

   for(int i = 1; i <= n; i++)
   {
       string line;
       cin >> line;

       int m = (line[0]-'0')*10 + (line[1]-'0');
       int d = (line[2]-'0')*10 + (line[3]-'0');
       int y = (line[4]-'0')*1000 + (line[5]-'0')*100 + (line[6]-'0')*10 + (line[7]-'0');

       int daysleft = 280;
       int days = months[m-1];
       while(daysleft > days)
       {
           days = months[m-1];
           if (((y%4 == 0 && y%100 != 0) || y%400 == 0) && m == 2)
               days++;

           daysleft -= days;
           d += days;
           if (d > days)
           {
               d -= days;
               m++;
               if (m > 12) {
                   m = 1;
                   y++;
               }
           }
       }
       d += daysleft;
       if (d > days)
           {
               d -= days;
               m++;
               if (m > 12) {
                   m = 1;
                   y++;
               }
           }

       string z = zodiac(d,m,y);
       z[0] = tolower(z[0]);
       string ds = (d <= 9) ? '0' + SSTR(d) : SSTR(d);
       string ms = (m <= 9) ? '0' + SSTR(m) : SSTR(m);
       string ys = SSTR(y);
       int add = 4-ys.length();
       while(add--)
           ys = '0'+ys;

       cout << i << " " << ms << "/" << ds << "/" << ys << " " << z << endl;
   }
}

string zodiac(int day,int month,int year)
{
   switch (month) {
           case 1: return  (day <= 20) ? "Capricorn"
           : "Aquarius";
           break;
           case 2: return  (day <= 19) ? "Aquarius"
           : "Pisces";
           break;
           case 3: return  (day <= 20) ? "Pisces"
           : "Aries";
           break;
           case 4: return  (day <= 20) ? "Aries"
           : "Taurus";
           break;
           case 5: return  (day <= 21) ? "Taurus"
           : "Gemini";
           break;
           case 6: return  (day <= 21) ? "Gemini"
           : "Cancer";
           break;
           case 7: return  (day <= 22) ? "Cancer"
           : "Leo";
           break;
           case 8: return  (day <= 21) ? "Leo"
           : "Virgo";
           break;
           case 9: return  (day <= 23) ? "Virgo"
           : "Libra";
           break;
           case 10: return  (day <= 23) ? "Libra"
           : "Scorpio";
           break;
           case 11: return  (day <= 22) ? "Scorpio"
           : "Sagittarius";
           break;
           case 12: return  (day <= 22) ? "Sagittarius"
           : "Capricorn";
           break;
           default : return "";
}
}
