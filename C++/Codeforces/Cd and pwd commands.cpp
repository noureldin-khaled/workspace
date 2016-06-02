#include <bits/stdc++.h>

using namespace std;

vector<string> trim(string path);
int main()
{
	int n;
	scanf("%i",&n);

	stack<string> s;
	while(n--)
	{
		string command;
		cin >> command;

		if (command.compare("pwd") == 0)
		{
			stack<string> temp;
			cout << "/";
			while(!s.empty())
			{
				temp.push(s.top());
				s.pop();
			}

			while(!temp.empty())
			{
				cout << temp.top() << "/";
				s.push(temp.top());
				temp.pop();
			}

			cout << endl;
		}
		else
		{
			string path;
			cin >> path;

			vector<string> v = trim(path);

			// for (int i = 0; i < v.size(); i++)
			// 	cout << v[i] << " ";
			// cout << endl;
			if (path[0] == '/')
			{
				while(!s.empty())
					s.pop();
			}

			for (int i = 0; i < v.size(); i++)
			{
				if (v[i].compare(".") == 0)
					continue;
				else if (v[i].compare("..") == 0)
					s.pop();
				else
					s.push(v[i]);
			}
		}
	}
}

vector<string> trim(string path)
{
	vector<string> res;
	string temp = "";
	int i = path[0] == '/' ? 1 : 0;
	for (; i < path.length(); i++)
	{
		if (path[i] == '/')
		{
			res.push_back(temp);
			temp = "";
		}
		else
			temp += path[i];
	}

	if (temp.compare("") != 0)
		res.push_back(temp);

	return res;
}
