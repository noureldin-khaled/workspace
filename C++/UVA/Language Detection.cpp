#include <bits/stdc++.h>

using namespace std;

int main()
{
	map<string, string> m;
	m["HELLO"] = "ENGLISH";
	m["HOLA"] = "SPANISH";
	m["HALLO"] = "GERMAN";
	m["BONJOUR"] = "FRENCH";
	m["CIAO"] = "ITALIAN";
	m["ZDRAVSTVUJTE"] = "RUSSIAN";
	string s;
	int t = 1;
	while(true)
	{
		cin >> s;
		if (s.compare("#") == 0) break;

		printf("Case %i: ", t++);
		if (m.find(s) == m.end())
			puts("UNKNOWN");
		else
			cout << m.find(s)->second << endl;
	}
}
