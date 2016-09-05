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
#define INF (int)1e9
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

int t, m1, m2, x, y, n, xi, yi;
ii a[15];
int dp[15][2000];

int dist(ii p1, ii p2);
int rec(int node, int msk);
int main()
{
	si(t);
	while(t--)
	{
		sii(m1, m2);
		sii(x, y);
		si(n);

		a[0] = mp(x, y);
		forn(i, n)
		{
			sii(xi, yi);
			a[i+1] = mp(xi, yi);
		}

		fill(dp, -1);
		printf("The shortest path has length %d\n", rec(0, 1));
	}
}

int rec(int node, int msk)
{
	if (msk == (1 << (n+1))-1)
		return dist(a[node], a[0]);

	if (dp[node][msk] != -1)
		return dp[node][msk];

	int ans = -1;
	forn(i, n+1)
	{
		if ((msk & (1 << i)) == 0)
		{
			int go = rec(i, msk | (1 << i)) + dist(a[node], a[i]);
			if (ans == -1 || go < ans)
				ans = go;
		}
	}

	return dp[node][msk] = ans;
}

int dist(ii p1, ii p2)
{
	return abs(p1.f - p2.f) + abs(p1.s - p2.s);
}