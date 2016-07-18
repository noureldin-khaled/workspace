#include <bits/stdc++.h>

using namespace std;

int main()
{
	int l, r, h;
	int arr[10005];
	int st = 10005;
	memset(arr, 0, sizeof arr);
	while(scanf("%i%i%i",&l,&h,&r) != EOF)
	{
		st = min(st, l);
		for (; l < r; l++)
			arr[l] = max(arr[l], h);
	}

	printf("%i",st);
	printf(" %i", arr[st]);
	st++;
	while(st < 10005)
	{
		if (arr[st] != arr[st-1])
		{
			printf(" %i", st);
			printf(" %i", arr[st]);
		}
		st++;
	}
	puts("");
}
