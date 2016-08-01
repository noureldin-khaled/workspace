#include <bits/stdc++.h>
#define toString( x ) dynamic_cast< std::ostringstream & >( \
( std::ostringstream() << std::dec << x ) ).str()
using namespace std;

int main()
{
	long long n, m;
	cin >> n >> m;

	set<int> cols;
	set<int> rows;
	int numCols = 0;
	int numRows = 0;

	string res = "";
	long long total = 0;
	for (int i = 0; i < m; i++)
	{
		int r, c;
		scanf("%i%i",&r,&c);

		long long deleted = 2*n - 1;
		set<int>::iterator it1 = cols.find(c);
		set<int>::iterator it2 = rows.find(r);

		if (it1 == cols.end())
		{
			cols.insert(c);
			if (it2 == rows.end())
				deleted -= numRows;
			else
				deleted -= (numRows-1);
		}
		else
		{
			deleted -= (n-1);
		}

		if (it2 == rows.end())
		{
			rows.insert(r);
			if (it1 == cols.end())
				deleted -= numCols;
			else
				deleted -= (numCols-1);
		}
		else
		{
			deleted -= (n-1);
		}

		if (it1 == cols.end())
			numCols++;
		if (it2 == rows.end())
			numRows++;

		if (it1 != cols.end() || it2 != rows.end())
			deleted--;

		total += deleted;
		long long rem = n*n - total;
		if (rem < 0)
			rem = 0;
		res += toString(rem);
		res += " ";
	}

	cout << res << endl;
}