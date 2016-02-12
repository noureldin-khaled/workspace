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

using namespace std;

int main()
{
    int n,k;
    scanf("%i %i",&n,&k);

    int arr[n];
    for(int i = 0; i < n; i++)
    {
        int a;
        scanf("%i",&a);

        int val = a + k;
        if (val > 100)
        {
            k = val - 100;
            val = 100;
        }
        else
            k = 0;
        arr[i] = val;
    }

    int sum = 0;
    for(int i = 0; i < n; i++)
        sum += arr[i]/10;

    printf("%i",sum);
}
