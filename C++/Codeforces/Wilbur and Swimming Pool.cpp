#include <bits/stdc++.h>

using namespace std;

int main()
{
    int n;
    scanf("%i",&n);

    if (n == 1)
        printf("%i",-1);
    else if (n == 2)
    {
        int x1,x2,y1,y2;
        scanf("%i %i",&x1,&y1);
        scanf("%i %i",&x2,&y2);

        if (x1 == x2 || y1 == y2)
            printf("%i",-1);
        else printf("%i",abs(x1-x2) * abs(y1-y2));
    }
    else if (n == 3)
    {
        int x1,x2,x3,y1,y2,y3;
        scanf("%i %i",&x1,&y1);
        scanf("%i %i",&x2,&y2);
        scanf("%i %i",&x3,&y3);

        if (x1 != x2 && y1 != y2)
            printf("%i",abs(x1-x2) * abs(y1-y2));
        else if (x1 != x3 && y1 != y3)
            printf("%i",abs(x1-x3) * abs(y1-y3));
        else
            printf("%i",abs(x2-x3) * abs(y2-y3));
    }
    else
    {
        int x1,x2,x3,x4,y1,y2,y3,y4;
        scanf("%i %i",&x1,&y1);
        scanf("%i %i",&x2,&y2);
        scanf("%i %i",&x3,&y3);
        scanf("%i %i",&x4,&y4);

        if (x1 != x2 && y1 != y2)
            printf("%i",abs(x1-x2) * abs(y1-y2));
        else if (x1 != x3 && y1 != y3)
            printf("%i",abs(x1-x3) * abs(y1-y3));
        else if (x1 != x4 && y1 != y4)
            printf("%i",abs(x1-x4) * abs(y1-y4));
        else if (x2 != x3 && y2 != y3)
            printf("%i",abs(x2-x3) * abs(y2-y3));
        else if (x2 != x4 && y2 != y4)
            printf("%i",abs(x2-x4) * abs(y2-y4));
        else
            printf("%i",abs(x3-x4) * abs(y3-y4));
    }
}
