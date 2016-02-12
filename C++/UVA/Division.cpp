#include <bits/stdc++.h>

using namespace std;

bool solve(int up, int down);
int len(int num);
bool isDistinct(int num1,int num2);
bool containsZero(int num);

int main()
{
   int t = 1;
   while(true)
   {
       int n;
       scanf("%i",&n);
       if (n == 0) break;
       if (t != 1)
           puts("");

       bool has = false;
       for(int i = 1; i <= 99999; i++)
       {
           int j = i*n;
           bool ans = solve(j, i);
           if (ans)
           {
               has = true;
               printf("%i\n",n);
           }
       }
       if (!has)
           printf("There are no solutions for %i.\n",n);
       t++;
   }
}

bool solve(int up, int down)
{
   int lenUp = len(up);
   int lenDown = len(down);

   if (lenUp > 5 || lenUp < 4 ||lenDown > 5 || lenDown < 4
   || ((lenDown == 4 || lenUp == 4) && (containsZero(down) || containsZero(up))) || (lenDown == 4 && lenUp == 4))
       return false;

   if (isDistinct(up , down))
   {
       if (lenUp == 5)
           printf("%i",up);
       else
           printf("0%i",up);

       printf(" / ");

       if (lenDown == 5)
           printf("%i",down);
       else
           printf("0%i",down);

       printf(" = ");
   }
}

int len(int num)
{
   int ans = 0;
   while(num !=0)
   {
       num /= 10;
       ans++;
   }
   return ans;
}

bool isDistinct(int num1,int num2)
{
   set<int> s;
   while(num1 != 0)
   {
       int digit = num1%10;
       if (s.find(digit) == s.end())
           s.insert(digit);
       else
           return false;
       num1 /= 10;
   }

   while(num2 != 0)
   {
       int digit = num2%10;
       if (s.find(digit) == s.end())
           s.insert(digit);
       else
           return false;
       num2 /= 10;
   }

   return true;
}

bool containsZero(int num)
{
   while(num != 0)
   {
       int digit = num%10;
       if (digit == 0)
           return true;
       num /= 10;
   }
   return false;
}
