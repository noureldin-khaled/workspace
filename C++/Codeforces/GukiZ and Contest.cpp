#include <iostream>
#include <string>
#include <algorithm>
#include <vector>

using namespace std;
vector<int> removeDups(vector<int> a);

int main()
{
   int n;
   cin >> n;

   vector<int> v(n);
   vector<int> vCopy(n);


   for (int i = 0; i < n; i++){
       int a;
       cin >> a;
       v[i] = a;
       vCopy[i] = a;
   }

   sort(vCopy.begin(), vCopy.end());

   reverse(vCopy.begin(),vCopy.end());

   vCopy = removeDups(vCopy);

   int c = 1;
   vector<int> pos(n);

   for (int i = 0; i < vCopy.size(); i++)
   {
       int inc = 0;
       for (int j = 0; j < v.size() && vCopy[i] != 0; j++)
       {
           if (vCopy[i] == v[j]){
               pos[j] = c;
               inc++;
           }
       }
       c += inc;
   }

   for (int i = 0; i < pos.size(); i++)
   {
       cout << pos[i] << " ";
   }
   return 0;
}

vector<int> removeDups(vector<int> a){
   vector<int> res(a.size());
   int k = 0;
   for (int i = 0; i < a.size(); i++)
   {
       bool found = false;
       for (int j = 0; j < res.size() && !found; j++)
       {
           if (res[j] == a[i])
               found = true;
       }
       if (!found)
       {
           res[k] = a[i];
           k++;
       }
   }

   return res;
}
