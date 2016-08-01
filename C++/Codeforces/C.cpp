#include <bits/stdc++.h>
#define fast std::ios_base::sync_with_stdio(false);cin.tie(0);


using namespace std;

struct Sensor
{
	double x, y, r;
	double distance(Sensor s)
	{
		return sqrt(sq(x-s.x) + sq(y-s.y)) - r - s.r;
	}

	double sq(double n)
	{
		return n*n;
	}
};

class UnionFind {
	vector<int> p, rank, setSize;  
	int numSets;
public:
	UnionFind(int N) 
	{
		setSize.assign(N, 1); numSets = N; rank.assign(N, 0);
		p.assign(N, 0); for (int i = 0; i < N; i++) p[i] = i; 
	}
	int findSet(int i) 
	{ 
		return (p[i] == i) ? i : (p[i] = findSet(p[i])); 
	}
	bool isSameSet(int i, int j) 
	{ 
		return findSet(i) == findSet(j); 
	}
	void unionSet(int i, int j) { 
		if (!isSameSet(i, j))
		{ 
			numSets--; 
			int x = findSet(i), y = findSet(j);
			if (rank[x] > rank[y]) { 
				p[y] = x; setSize[x] += setSize[y]; 
			}
			else                   {
				p[x] = y; setSize[y] += setSize[x];
				if (rank[x] == rank[y]) rank[y]++;
			} 
		} 
	}
	int numDisjointSets() 
	{
		return numSets; 
	}
	int sizeOfSet(int i) 
	{
		return setSize[findSet(i)]; 
	}
};


int w, n;
Sensor a[1005];

bool valid(double ans);
int main()
{
	fast

	int t;
	cin >> t;

	while(t--)
	{
		cin >> w >> n;
		for (int i = 0; i < n; i++)
		{
			double x, y, r;
			cin >> x >> y >> r;
			Sensor s;
			s.x = x; s.y = y; s.r = r;
			a[i] = s;
		}

		double low = 0.0;
		double high = w/2.0;

		for (int i = 0; i < 50; i++)
		{
			double mid = low + (high-low)/2.0;

			if (valid(2*mid))
				low = mid;
			else
				high = mid;
		}

		printf("%.6f\n", low);
	}
}

bool valid(double ans)
{
	UnionFind UF(n+2);

	for (int i = 0; i < n; i++)
	{
		Sensor cur = a[i];
		if (cur.x - cur.r <= ans)
			UF.unionSet(0, i+2);

		if (w - cur.x - cur.r <= ans)
			UF.unionSet(1, i+2);

		for (int j = i+1; j < n; j++)
		{
			Sensor other = a[j];

			double d = cur.distance(other);
			if (d <= ans)
				UF.unionSet(i+2, j+2);
		}
	}

	return !UF.isSameSet(0, 1);
}
