#include <bits/stdc++.h>

using namespace std;

int main()
{
	string line;
	cin >> line;

	vector<int> AB;
	vector<int> BA;

	for (int i = 0; i < line.length() - 1; i++)
	{
		if (line[i] == 'A' && line[i+1] == 'B')
			AB.push_back(i);
		else if (line[i] == 'B' && line[i+1] == 'A')
			BA.push_back(i);
	}

	int len1 = AB.size();
	int len2 = BA.size();

	bool contains = false;
	for (int i = 0; i < len1 && !contains; i++)
	{
		for (int j = 0; j < len2 && !contains; j++)
		{
			if (abs(AB[i] - BA[j]) > 1)
				contains = true;
		}
	}

	if (contains)
		puts("YES");
	else
		puts("NO");
}
