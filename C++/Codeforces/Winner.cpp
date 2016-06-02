#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	map<string, int> m;

	pair<string, int> arr[n];
	for (int i = 0; i<  n; i++)
	{
		string name;
		int score;
		cin >> name;
		scanf("%i",&score);

		arr[i] = make_pair(name, score);

		map<string, int>::iterator it = m.find(name);
		if (it == m.end()) 
			m[name] = score;
		else
			it->second += score;
	}

	int max = 0;

	for (map<string, int>::iterator it = m.begin(); it != m.end(); ++it)
	{
		string name = it->first;
		int score = it->second;

		if (score > max)
			max = score;
	}

	set<string> s;
	for (map<string, int>::iterator it = m.begin(); it != m.end(); ++it)
	{
		string name = it->first;
		int score = it->second;

		if (score == max)
			s.insert(name);
	}

	map<string, int> m2;
	for (int i = 0; i < n; i++)
	{
		string name = arr[i].first;
		int score = arr[i].second;

		map<string, int>::iterator it = m2.find(name);

		if (it == m2.end()) 
		{
			m2[name] = score;
			if (s.find(name) != s.end() && score >= max)
			{
				cout << name << endl;
				return 0;
			}
		}
		else
		{
			it->second += score;
			if (s.find(name) != s.end() && it->second >= max)
			{
				cout << name << endl;
				return 0;
			}
		}
	}
}