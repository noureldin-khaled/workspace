#include <iostream>

using namespace std;



int main()
{
   int n,k;
   cin >> n >> k;
   int value;
   int c = 0;
   int a;
   for(int i = 1;i <= n; i++){
       cin >> a;
       if (a > 0){
       if (i == k)
          value = a;

       if (i < k || a == value)
           c++;
       }
   }
   cout << c << endl;


   return 0;
}
