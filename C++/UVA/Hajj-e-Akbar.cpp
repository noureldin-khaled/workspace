#include <bits/stdc++.h>

using namespace std;

int main()
{
    int t = 1;
    string s;
    while(true)
    {
        cin >> s;
        if (s.compare("*") == 0) break;

        printf("Case %i: ", t++);
        if (s.compare("Hajj") == 0)
            puts("Hajj-e-Akbar");
        else
            puts("Hajj-e-Asghar");
    }
}
