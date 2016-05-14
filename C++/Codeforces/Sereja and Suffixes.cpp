#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, m;
	scanf("%i%i",&n,&m);

	int arr[n];
	for (int i = 0; i < n; i++)
		scanf("%i",&arr[i]);

	set<int> s;
	int ans[n];
	ans[n-1] = 1;
	s.insert(arr[n-1]);
	for (int i = n-2; i >= 0; i--)
	{
		ans[i] = ans[i+1];
		if (s.find(arr[i]) == s.end())
		{
			s.insert(arr[i]);
			ans[i]++;
		}
	}



	while(m--)
	{
		int l;
		scanf("%i",&l);

		printf("%i\n",ans[l-1]);
	}
}
