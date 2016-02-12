#include <bits/stdc++.h>

using namespace std;

int main()
{
    vector<int> v;
    int i = 0;
    int a;
    while(scanf("%i",&a) != EOF)
    {
        v.push_back(a);
        i++;
    }

    int n = v.size();
    int tail[n];
    int P[n];
    memset(tail,0,sizeof tail);

    tail[0] = v[0];
    int len = 1;
    for(i = 1; i < n; i++)
    {
        if (v[i] < tail[0])
            tail[0] = v[i];
        else if (v[i] > tail[len-1])
            tail[len++] = v[i];
        else
        {
            int l = -1;
            int r = len-1;
            while(r-l > 1)
            {
                int m = l + (r-l)/2;
                if (tail[m] >= v[i])
                    r = m;
                else
                    l = m;
            }
            tail[r] = v[i];
        }
    }
    printf("%i\n-\n",len);

}
