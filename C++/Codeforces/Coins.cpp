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

using namespace std;

int main()
{
    int n;
    scanf("%i",&n);

    while(true) {
        printf("%i ",n);
        if (n == 1) break;
        int square_root = sqrt(n) + 1;
        int temp = n;
        for (int i = 2; i < square_root; i++){
            if (n%i == 0) {
                n /= i;
                break;
            }
        }
        if (n == temp)
            n = 1;

    }
}
