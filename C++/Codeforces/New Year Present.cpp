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

	string ans = "";
	bool flag = true;
	int s = 0;
	while(true)
	{
		bool done = true;
		for (int i = 0; i < n && done; i++)
		{
			if (arr[i] > 0)
				done = false;
		}
		if (done) break;

		if (flag) // right
		{
			for (int i = 0; i < n; i++)
			{
				if (arr[i] > 0 && (s == 0 || (s > 0 && ans[s-1] != 'P')))
				{
					arr[i]--;
					ans += 'P';
					s++;
				}
				if (i < n-1)
				{
					ans += 'R';
					s++;
				}
			}
			flag = false;
		}
		else // left
		{
			for (int i = n-1; i >= 0; i--)
			{
				if (arr[i] > 0 && (s == 0 || (s > 0 && ans[s-1] != 'P')))
				{
					arr[i]--;
					ans += 'P';
					s++;
				}
				if (i > 0)
				{
					ans += 'L';
					s++;
				}
			}
			flag = true;
		}
	}

	cout << ans << endl;
}
