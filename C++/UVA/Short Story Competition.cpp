#include <bits/stdc++.h>

using namespace std;

int main()
{
   int n, l, c;
   while(scanf("%i %i %i",&n,&l,&c) != EOF)
   {
       int arr[n];
       for(int i = 0; i < n; i++)
       {
           string s;
           cin >> s;
           arr[i] = s.length();
       }

       int word = 0;
       int charCount = 0;
       int lineCount = 0;
       bool lineStart = true;
       int pages = 0;
       while(word < n)
       {
           int characters = arr[word];
           if (!lineStart)
               characters++;
           if (charCount + characters <= c)
           {
               if (lineStart)
               {
                   if (lineCount == 0)
                       pages++;
                   lineCount++;
                   if (lineCount == l)
                       lineCount = 0;
               }
               charCount += characters;
               word++;
               lineStart = false;
           }
           else
           {
               if (lineStart)
                   break;
               lineStart = true;
               charCount = 0;
           }
       }

       printf("%i\n",pages);
   }
}
