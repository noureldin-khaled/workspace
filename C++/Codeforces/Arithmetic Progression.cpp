#include <bits/stdc++.h>

using namespace std;

// Input macros
#define fast ios_base::sync_with_stdio(0);cin.tie(0);
#define si(n) scanf("%d",&n)
#define sii(n, m) scanf("%d%d",&n,&m)
#define siii(n, m, x) scanf("%d%d%d",&n,&m,&x)
#define sc(n) scanf(" %c",&n)
#define sd(n) scanf("%lf",&n)
#define read(s) freopen(s, "r", stdin)
#define write(s) freopen(s, "w", stdout);
#define endl '\n'

// Useful constants
#define INF (ll)1e17
#define EPS 1e-9

// Useful hardware instructions
#define bitcount __builtin_popcount
#define gcd __gcd

// Traversal macros
#define forn(i,n) for (int i = 0; i < n; i++)
#define forr(i,n) for (int i = n-1; i >= 0; i--)
#define forall(i,a,b,x) for (int i = a; i < b; i+=x)
#define foreach(v, c) for (typeof(c.begin()) v = c.begin(); v != c.end(); v++)

// Useful container manipulation
#define all(a) a.begin(), a.end()
#define in(a, b) (b.find(a) != b.end())
#define pb push_back
#define fill(a,v) memset(a, v, sizeof a)
#define sz(a) ((int)(a.size()))
#define mp make_pair
#define f first
#define s second
#define parseInt(x) atoi(x.c_str())
#define parseLong(x) atol(x.c_str())
#define charToInt(x) x - '0'
#define intToChar(x) x + '0'
#define toString(x) dynamic_cast< std::ostringstream & >( \
( std::ostringstream() << std::dec << x ) ).str()

// Printing
#define print(a,s) {forn(i, s) { if (i > 0) cout << " "; cout << a[i];} puts("");}

typedef long long ll;
typedef pair<int, int> ii;
typedef pair<long long, long long> llll;
typedef vector<int> vi;
typedef vector<long long> vl;
typedef vector<pair<int, int> > vii;
typedef vector<pair<long long, long long> > vll;

int n;
int a[100001];

bool already();
int main()
{
	si(n);
	forn(i, n)
		si(a[i]);

	sort(a, a+n);
	if (n == 1)
		puts("-1");
	else if (n == 2)
	{
		int diff = a[1] - a[0];
		set<int> s;
		s.insert(a[0]-diff);
		s.insert(a[n-1] + diff);
		if (diff%2 == 0)
			s.insert(a[0] + (diff/2));
		int size = s.size();
		printf("%d\n", size);
		for (set<int>::iterator it = s.begin(); it != s.end(); ++it)
			printf("%d ", *it);
	}
	else
	{
		if (already())
		{
			int diff = a[1] - a[0];
			set<int> s;
			s.insert(a[0]-diff);
			s.insert(a[n-1] + diff);
			int size = s.size();
			printf("%d\n", size);
			for (set<int>::iterator it = s.begin(); it != s.end(); ++it)
				printf("%d ", *it);
		}
		else
		{
			map<int, int> m;
			int size = 0;
			forall(i, 0, n-1, 1)
			{
				int diff = a[i+1]-a[i];
				map<int, int>::iterator it = m.find(diff);
				if (it == m.end())
				{
					m[diff] = 1;
					size++;
				}
				else
					it->second++;

				if (size > 2)
				{
					printf("%d\n", 0);
					return 0;
				}
			}

			int d = -1;
			for (map<int, int>::iterator it = m.begin(); it != m.end(); ++it)
			{
				if (it->second == (n-2))
				{
					if (d == -1 || it->first < d)
						d = it->first;
				}
			}

			forall(i, 0, n-1, 1)
			{
				int diff = a[i+1]-a[i];
				if (diff != d)
				{
					int num = a[i]+d;
					if (a[i+1]-num == d)
					{
						printf("%d\n%d\n", 1, num);
						return 0;
					}
					else
					{
						printf("%d\n", 0);
						return 0;
					}
				}
			}
		}
	}
}

bool already()
{
	int d = a[1]-a[0];
	forall(i, 1, n-1, 1)
		if (a[i+1]-a[i] != d)
			return false;

	return true;
}