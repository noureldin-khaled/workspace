#include <iostream>
#include <vector>

using namespace std;

int main(){
   int n, m, b, g;
   vector <int> boys,girls;

   cin >> n >> m;

   cin >> b;
   for (int i = 0; i < n; i++){
       boys.push_back(0);
   }
   for (int i = 0; i < b; i++){
       int k;
       cin >> k;
       boys[k] = 1;
   }


   cin >> g;
   for (int i = 0; i < m; i++){
       girls.push_back(0);
   }
   for (int i = 0; i < g; i++){
       int l;
       cin >> l;
       girls[l] = 1;
   }

   int s = 0;
//    bool flag = false;
//    bool flag2 = false;
   while (s <= 100*n*m){
       if (boys[s % n] == 1 || girls[s % m] == 1){
           boys[s % n] = 1;
           girls[s % m] = 1;
       }
       s++;
   }



//    for (int i = 0; i < n; i++){
//        if (boys[i] == 0){
//            flag = false;
//            break;
//        }
//        else{
//            flag = true;
//        }
//    }
//
//    for (int i = 0; i < m; i++){
//        if (girls[i] == 0){
//            flag2 = false;
//            break;
//        }
//        else{
//            flag2 = true;
//        }
//    }
//
//
//    if (flag && flag2){
//        cout << "Yes" << endl;
//    }
//    else{
//        cout << "No" << endl;
//    }
   for(int i = 0; i < n; i++)
   {
       if (boys[i] == 0)
       {
           cout << "No" << endl;
           return 0;
       }
   }

   for(int i = 0; i < m; i++)
   {
       if (girls[i] == 0)
       {
           cout << "No" << endl;
           return 0;
       }
   }

   cout << "Yes" << endl;


}
