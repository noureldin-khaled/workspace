#include <bits/stdc++.h>

using namespace std;

int main()
{
   int n, p, q;
   scanf("%i %i %i",&n,&p,&q);

   string s;
   cin >> s;

   vector<string> ans;
   if (n%p == 0)
   {
       int pieces = n/p;
       int pos = 0;
       for(int i = 0; i < pieces; i++)
       {
           int counter = 0;
           string temp = "";
           for(; pos < n; pos++)
           {
               if (counter == p)
               {
                   counter = 0;
                   break;
               }
               temp += s[pos];
               counter++;
           }
           ans.push_back(temp);
       }
   }
//    else if (n%q == 0)
//    {
//        int pieces = n/q;
//        int pos = 0;
//        for(int i = 0; i < pieces; i++)
//        {
//            int counter = 0;
//            string temp = "";
//            for(; pos < n; pos++)
//            {
//                if (counter == q)
//                {
//                    counter = 0;
//                    break;
//                }
//                temp += s[pos];
//                counter++;
//            }
//            ans.push_back(temp);
//        }
//    }
   else
   {
       int rem_length = n;
       int pos = 0;
       bool valid = true;
       while(valid)
       {
           if (rem_length < q)
               valid = false;
           else if (rem_length%q == 0)
           {
               int pieces = rem_length/q;
               for(int i = 0; i < pieces; i++)
               {
                   int counter = 0;
                   string temp = "";
                   for(; pos < n; pos++)
                   {
                       if (counter == q)
                       {
                           counter = 0;
                           break;
                       }
                       temp += s[pos];
                       counter++;
                   }
                   ans.push_back(temp);
               }
               break;
           }
           else
           {
               int counter = 0;
               string temp = "";
               for(; pos < n; pos++)
               {
                   if (counter == p)
                       break;
                   temp += s[pos];
                   counter++;
               }
               rem_length -= p;
               ans.push_back(temp);
           }
       }
       if (!valid)
       {
           printf("%i",-1);
           return 0;
       }
   }

   int sizee = ans.size();
   printf("%i\n",sizee);
   for(int i = 0; i < sizee; i++)
       cout << ans[i] << endl;

}
