#include <iostream>
#include <string>
#include <cstring>
#include <cstdlib>

using namespace std;

int main()
{
   string s;
   getline(cin,s);

   int n = atoi(s.c_str());
   int arr[4];
   for(int i = 0; i < 4; i++)
       arr[i] = 0;

   string line;
   getline(cin, line);

   for(int i = 0; i < line.length(); i+=2){
       int a = line[i] - '0';
       arr[a]++;
   }
   int maximum = arr[1];
   for(int i = 2; i < 4; i++){
       if (arr[i] > maximum)
           maximum = arr[i];
   }

   cout << n-maximum << endl;
}
