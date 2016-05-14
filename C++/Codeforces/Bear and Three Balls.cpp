#include <bits/stdc++.h>

using namespace std;

bool valid(int a, int b, int c);
int main()
{
	int n;
	scanf("%i", &n);

	int arr[n];
	for (int i = 0; i < n; i++)
		scanf("%i", &arr[i]);

	for (int i = 0; i < n; i++)
		for (int j = i + 1; j < n; j++)
			for (int k = j + 1; k < n; k++)
				if (valid(arr[i], arr[j], arr[k]))
				{
					puts("YES");
					return 0;
				}

	puts("NO");
}

bool valid(int a, int b, int c) 
{
	if (a == b || a == c || b == c)
		return false;

	if (abs(a - b) > 2 || abs(a - c) > 2 || abs(b - c) > 2)
		return false;

	return true;
}
