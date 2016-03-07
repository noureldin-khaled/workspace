#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	int arr[n];
	for (int i = 0; i < n; i++)
	{
		int a;
		scanf("%i",&a);

		arr[i] = a;
	}

	sort(arr, arr + n);

	bool used[n];
	for (int i = 0; i < n; i++)
		used[i] = false;

	long long ans = 0;
	for (int i = 0; i < n; i++)
		for (int j = i+1; j < n; j++)
			if (arr[j] > arr[i] && !used[j])
			{
				ans++;
				used[j] = true;
				break;
			}

	cout << ans << endl;
}