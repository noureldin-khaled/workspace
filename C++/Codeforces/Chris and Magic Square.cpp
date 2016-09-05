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
int a[501][501];

int main()
{
	si(n);

	if (n == 1)
	{
		printf("%d\n", 1);
		return 0;
	}

	ii p = mp(-1, -1);
	forn(i, n)
		forn(j, n)
		{
			si(a[i][j]);
			if (a[i][j] == 0)
				p = mp(i, j);
		}

	ll d = 0;
	bool valid = true;
	forn(i, n)
	{
		if (i == p.f) continue;

		ll cur = 0;
		forn(j, n)
			cur += a[i][j];

		if (d == 0)
			d = cur;
		else if (d != cur)
		{
			valid = false;
			break;
		}
	}

	if (!valid)
	{
		printf("%d\n", -1);
		return 0;
	}

	forn(j, n)
	{
		if (j == p.s) continue;

		ll cur = 0;
		forn(i, n)
			cur += a[i][j];
		
		if (d != cur)
		{
			valid = false;
			break;
		}
	}

	if (!valid)
	{
		printf("%d\n", -1);
		return 0;
	}

	if (p.f != p.s)
	{
		ll cur = 0;
		forn(i, n)
			cur += a[i][i];

		if (d != cur)
		{
			printf("%d\n", -1);
			return 0;
		}
	}

	if (p.f + p.s != n-1)
	{
		ll cur = 0;
		forn(i, n)
			cur += a[i][n-1-i];

		if (d != cur)
		{
			printf("%d\n", -1);
			return 0;
		}
	}

	ll val = 0;
	forn(j, n)
		if (a[p.f][j] != 0)
			val += a[p.f][j];

	ll cur = 0;
	forn(i, n)
		if (a[i][p.s] != 0)
			cur += a[i][p.s];

	if (cur != val)
	{
		printf("%d\n", -1);
		return 0;
	}

	if (p.f == p.s)
	{
		cur = 0;
		forn(i, n)
			if (a[i][i] != 0) 
				cur += a[i][i];

		if (cur != val)
		{
			printf("%d\n", -1);
			return 0;
		}
	}

	if (p.f + p.s == n-1)
	{
		cur = 0;
		forn(i, n)
			cur += a[i][n-1-i];

		if (cur != val)
		{
			printf("%d\n", -1);
			return 0;
		}
	}

	ll ans = d-val;
	if (ans >= 1 && ans <= 1000000000000000000)
		cout << d - val << endl;
	else
		printf("%d\n", -1);
}
