#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, m;
	scanf("%i%i",&n, &m);

	queue<pair<int, int> > q;
	for (int i = 0; i < n; i++)
	{
		int a;
		scanf("%i",&a);

		q.push(make_pair(a, i+1));
	}

	int last = -1;
	while(!q.empty())
	{
		pair<int, int> e = q.front();
		q.pop();

		if (e.first > m)
		{
			e.first -= m;
			q.push(e);
		}
		else
			last = e.second;
	}

	printf("%i\n", last);
}