#include <bits/stdc++.h>


using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	map<string, int> m;
	for (int i = 0; i < n; i++)
	{
		string s;
		cin >> s;

		map<string, int>::iterator it = m.find(s);	
		if (it == m.end())
		{
			m[s] = 0;
			cout << "OK" << endl;
		}
		else
		{	
			it->second++;
			cout << it->first << it->second << endl;
		}
	}
}