#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	if (n > 26)
	{
		cout << -1 << endl;
		return 0;
	}
	string s;
	cin >> s;

	int arr[26];
	memset(arr, 0, sizeof arr);
	for (int i = 0; i < n; i++)
		arr[s[i] - 'a']++;

	int ans = 0;
	for (int i = 0; i < 26; i++)
	{
		if (arr[i] == 0) continue;

		ans += (arr[i]-1);
	}

	cout << ans << endl;
}

