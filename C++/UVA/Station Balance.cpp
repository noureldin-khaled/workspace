#include <bits/stdc++.h>

using namespace std;

int main()
{
   int s, c;
   int setno = 1;
   while(scanf("%i %i",&c, &s) != EOF)
   {
       if (setno != 1)
           printf("\n");

       int orignal[s];
       int arr[2*c];
       int sum = 0;
       memset(arr, 0, sizeof arr);
       for(int i = 0; i < s; i++)
       {
           int a;
           scanf("%i",&a);
           arr[i] = a;
           orignal[i] = a;
           sum += arr[i];
       }

       double avg = (sum*1.0)/c;

       sort(arr, arr+(2*c));
       pair<int, int> res[c];

       int index = 0;
       for(int i = 0; i < s; i++)
       {
           int element = orignal[i];

           for(int j = 0; j < 2*c; j++)
           {
               if (element == arr[j])
               {
                   res[index++] = make_pair(arr[j], arr[2*c - j - 1]);
                   arr[j] = -1;
                   arr[2*c - j - 1] = -1;
                   break;
               }
           }
       }


       printf("Set #%i\n",setno++);
       for(int i = 0; i < c; i++)
       {
           printf(" %i:", i);
           if (res[i].first != 0)
               printf(" %i", res[i].first);
           if (res[i].second != 0)
               printf(" %i", res[i].second);
           printf("\n");
       }

       double imbalance = 0;
       for(int i = 0; i < c; i++)
           imbalance += (abs(avg - (res[i].first + res[i].second)));

       printf("IMBALANCE = %.5f\n", imbalance);
   }

   puts("");
}
