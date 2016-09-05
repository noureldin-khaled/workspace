#include <bits/stdc++.h>

using namespace std;

// Input macros
#define fast ios_base::sync_with_stdio(0);cin.tie(0);
#define s(n) int n; scanf("%d",&n)
#define sc(n) char n; scanf(" %c",&n)
#define sl(n) long long n; scanf("%lld",&n)
#define sd(n) double n; scanf("%lf",&n)
#define ss(n, sz) char str[sz]; scanf("%s",str); string n = str

// Useful constants
#define INF (int)2e9
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
#define parseInt(x) atoi(x.c_str())
#define parseLong(x) atol(x.c_str())
#define charToInt(x) x - '0'
#define intToChar(x) x + '0'
#define toString(x) dynamic_cast< std::ostringstream & >( \
( std::ostringstream() << std::dec << x ) ).str()

// Printing
#define print(a,s) {forn(i, s) { if (i > 0) printf(" "); printf("%i", a[i]);} puts("");}

typedef long long ll;
typedef pair<int, int> ii;
typedef pair<long long, long long> llll;
typedef vector<int> vi;
typedef vector<long long> vl;
typedef vector<pair<int, int> > vii;
typedef vector<pair<long long, long long> > vll;

int a[26][26];
int active[26];
vi c[26];
int tim[26];

void connect(int u, int v);
int main()
{
	int n;
	while(scanf("%d",&n) != EOF)
	{
		s(m);
		fill(a, 0);
		fill(active, 0);
		fill(tim, 0);
		forn(i, 26)
		{
			c[i].clear();
		}

		sc(c1);
		sc(c2);
		sc(c3);
		active[c1-'A'] = active[c2-'A'] = active[c3-'A'] = 1;

		forn(i, m)
		{
			sc(a);
			sc(b);

			int u = a-'A';
			int v = b-'A';

			connect(u, v);
		}

		int c = 0;
		forn(i, 26)
		{
			if (active[i])
				c++;
		}

		if (c < n)
			puts("THIS BRAIN NEVER WAKES UP");
		else
		{
			int ans = 0;
			forn(i, 26)
			{
				ans = max(ans, tim[i]);
			}

			printf("WAKE UP IN, %i, YEARS\n", ans);
		}
	}
}

void connect(int u, int v)
{
	if (active[u] && active[v]) return;

	if (active[u])
		c[v].pb(u);
	else if (active[v])
		c[u].pb(v);
	else
		a[u][v] = a[v][u] = 1;

	queue<int> q;
	if (c[u].size() >= 3 && !active[u])
		q.push(u);

	if (c[v].size() >= 3 && !active[v])
		q.push(v);

	while(!q.empty())
	{
		int cur = q.front();q.pop();
		active[cur] = 1;
		int t = 0;
		forn(i, 3)
		{
			t = max(t, tim[c[cur][i]]);
		}

		tim[cur] = t+1;

		forn(i, 26)
		{
			if (a[cur][i])
			{
				c[i].pb(cur);
				if (c[i].size() >= 3 && !active[i])
					q.push(i);
			}
		}
	}
}