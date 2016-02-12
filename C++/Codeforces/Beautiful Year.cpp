#include <iostream>
#include <string>

using namespace std;

bool isDistinct(int y);
int main()
{
   int y;
   cin >> y;
   y++;

   while(true){
      if (isDistinct(y))
           break;
       y++;
   }

   cout << y << endl;

}

bool isDistinct(int y){
   int arr[4];
   int counter = 0;
   for(int i = 0; i < 4; i++)
       arr[i] = -1;

   while (y != 0)
   {
       int digit = y%10;
       for(int i = 0; i < 4; i++)
           if (digit == arr[i])
               return false;

       arr[counter] = digit;
       counter++;
       y = y/10;

   }

   return true;
}
