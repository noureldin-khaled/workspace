#include <bits/stdc++.h>

using namespace std;

int main()
{
	map<string, int> m;
	int count = 0;
	while(true)
	{
		string word;
		cin >> word;
		if (word.compare("--") == 0) break;

		m[word] = count++;
	}

	int dist[count];
	string a, b;
	while(cin >> a >> b)
	{
		int l1 = a.length(), l2 = b.length();
		memset(dist, -1, sizeof dist);

		int idx = m.find(a)->second;
		int target = m.find(b)->second;
		queue<string> q;
		q.push(a);
		dist[idx] = 0;

		bool found = false;
		while(!q.empty())
		{
			string cur = q.front();
			q.pop();
			int curIdx = m.find(cur)->second;

			if (curIdx == target)
			{
				found = true;
				break;
			}

			for (int j = 0; j < l1; j++)
			{
				for (int i = 0; i < 26; i++)
				{
					char c = (char)(i+'a');
					if (c == cur[j]) continue;

					string tmp = cur;
					tmp[j] = c;
					map<string, int>::iterator it = m.find(tmp);
					if (it != m.end() && dist[it->second] == -1)
					{
						dist[it->second] = dist[curIdx] + 1;
						q.push(tmp);
					}
				}
			}
		}

		if (found)
			puts("Yes");
		else
			puts("No");
	}
}
