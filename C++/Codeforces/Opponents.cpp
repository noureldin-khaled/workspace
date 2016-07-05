#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, d;
	scanf("%i%i",&n,&d);

	int ans = 0;
	int cur = 0;
	for (int i = 0; i < d; i++)
	{
		bool allPresent = true;
		string line;
		cin >> line;
		for (int j = 0; j < n; j++)
			if (line[j] == '0')
				allPresent = false;

		if (!allPresent)
			cur++;
		else
			cur = 0;
		ans = max(cur, ans);
	}

	printf("%i\n",ans);
}

