#include <bits/stdc++.h>

using namespace std;

bool cmp(pair<int, pair<int, char> > p1, pair<int, pair<int, char> > p2)
{
	if (p1.first != p2.first)
		return p1.first < p2.first;
	if (p1.second.first != p2.second.first)
		return p1.second.first > p2.second.first;
	return p2.second.second < p1.second.second;
}

int main()
{
	int t;
	scanf("%i",&t);

	while(t--)
	{
		int q;
		scanf("%i",&q);

		pair<int, pair<int, char> > arr[q];
		for (int i = 0; i < q; i++)
		{
			int d, s;
			char r;
			scanf("%i%i",&d,&s);
			scanf(" %c",&r);

			arr[i] = make_pair(d, make_pair(s, r));
		}

		sort(arr, arr+q, cmp);

		int tmp = 0;
		int ans = 0;
		for (int i = 0; i < q; i++)
		{
			pair<int, pair<int, char> > cur = arr[i];
			if (cur.second.first == 0 && cur.second.second == 'i')
				tmp++;

			if (cur.second.first == 1 && cur.second.second == 'c')
				ans += tmp;
		}

		printf("%i\n", ans);
	}
}