#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	int arr[n];
	arr[0] = 0;
	for (int i = 1; i < n; i++)
	{
		int d;
		scanf("%i",&d);

		arr[i] = arr[i-1] + d;
	}

	int a, b;
	scanf("%i%i",&a, &b);

	cout << arr[b-1]-arr[a-1] << endl;
}

