#include <bits/stdc++.h>

using namespace std;

vector<int> adjlist[200005];
int main()
{
	int n;
	scanf("%i",&n);

	int arr[n];

	for (int i = 0; i < n; i++)
		scanf("%i",&arr[i]);

	for (int i = 0; i < n; i++)
	{
		if (i < n-1)
			adjlist[i].push_back(i+1);
		if (i > 0)
			adjlist[i].push_back(i-1);

		int go = arr[i]-1;
		if (go != i+1 && go != i-1 && go != i)
			adjlist[i].push_back(go);
	}

	queue<int> q;
	int dist[n];
	memset(dist, -1, sizeof dist);
	q.push(0);
	dist[0] = 0;

	while(!q.empty())
	{
		int cur = q.front();
		q.pop();

		for (int i = 0; i < adjlist[cur].size(); i++)
		{
			int nxt = adjlist[cur][i];
			if (dist[nxt] == -1)
			{
				dist[nxt] = dist[cur]+1;
				q.push(nxt);
			}
		}
	}

	for (int i = 0; i < n; i++)
		printf("%i ", dist[i]);
}
