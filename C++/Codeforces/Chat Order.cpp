#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	stack<string> s;
	for (int i = 0; i < n; i++)
	{
		string name;
		cin >> name;

		s.push(name);
	}

	string ans = "";
	set<string> st;
	while(!s.empty())
	{
		string e = s.top();s.pop();
		if (st.find(e) == st.end())
		{
			st.insert(e);
			ans += e + '\n';
		}

	}

	cout << ans << endl;
}
