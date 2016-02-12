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

class ii{
    public:
        int l;
        int h;
        ii(int l1,int h1) {
            l = l1;
            h = h1;
        }
};

int main()
{
    int t;
    while(t--)
    {
        int D;
        scanf("%i",&D);

        pair<string , ii>  arr[D];
        for(int i = 0; i < D; i++)
        {
            string s;
            int L,H;
            cin >> s >> L >> H;

            arr[i] = make_pair(s,ii(L,H));
        }

        int Q;
        scanf("%i",&Q);

        while(Q--)
        {
            int P;
            scanf("%i",&P);

            int count = 0;
            string car = "";
            for(int i = 0; i < D; i++)
            {
                if (P >= arr[i].second.l && P <= arr[i].second.h) {
                    count++;
                    car = arr[i].first;
                }

            }

            if (count == 1)
                cout << car << endl;
            else
                cout << "UNDETERMINED" << endl;
        }
        if (t > 0)
            puts("");
    }
 }
