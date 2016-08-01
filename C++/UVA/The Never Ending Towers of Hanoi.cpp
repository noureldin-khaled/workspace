#include <bits/stdc++.h>

using namespace std;

vector<int> a[3];
int moves, m;

void print();
void solve(int count, int source, int destination, int intermediate);
int main()
{
	int n;
	int t = 1;
	while(true)
	{
		scanf("%i%i",&n,&m);
		if (n+m == 0) break;

		for (int i = 0; i < 3; i++)
			a[i].clear();

		for (int i = n; i >= 1; i--)
			a[0].push_back(i);

		moves = 0;
		printf("Problem #%i\n\n", t++);
		print();
		puts("");
		solve(n, 0, 2, 1);
	}
}

void solve(int count, int source, int destination, int intermediate)
{
	if (moves == m)
		return;
	if (count == 1)
	{
		int e = a[source].back();
		a[source].pop_back();
		a[destination].push_back(e);
		moves++;
		print();
		puts("");
	}
	else {
		solve(count-1, source, intermediate, destination);
		solve(1, source, destination, intermediate);
		solve(count-1, intermediate, destination, source);
	}
}

void print()
{
	int l1 = a[0].size(), l2 = a[1].size(), l3 = a[2].size();
	printf("A=>");
	if (l1 > 0)
		printf("   ");
	for (int i = 0; i < l1; i++)
	{
		if (i > 0)
			printf(" ");
		printf("%i", a[0][i]);
	}
	puts("");
	
	printf("B=>");
	if (l2 > 0)
		printf("   ");
	for (int i = 0; i < l2; i++)
	{
		if (i > 0)
			printf(" ");
		printf("%i", a[1][i]);
	}
	puts("");

	printf("C=>");
		if (l3 > 0)
		printf("   ");
	for (int i = 0; i < l3; i++)
	{
		if (i > 0)
			printf(" ");
		printf("%i", a[2][i]);
	}
	puts("");

}