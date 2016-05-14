#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i", &n);

	string s;
	cin >> s;
	int arr[n];

	for (int i = 0; i < n; i++)
		scanf("%i", &arr[i]);

	bool visited[n];
	memset(visited, false, sizeof visited);
	
	int pos = 0;
	while(true)
	{
		int sign = 1;
		if (s[pos] == '<')
			sign = -1;

		pos += (arr[pos] * sign);
		if (pos < 0 || pos >= n)
		{
			puts("FINITE");
			return 0;
		}

		if (visited[pos])
		{
			puts("INFINITE");
			return 0;
		}

		visited[pos] = true;
	}
}
