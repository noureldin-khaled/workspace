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

int n, m, k;
int c[101];
int p[101][101];
ll dp[101][101][101];

ll rec(int idx, int prev, int remK);
int main()
{
	siii(n, m, k);
	forn(i, n)
		si(c[i]);

	forn(i, n)
		forn(j, m)
			si(p[i][j]);

	forn(i, 101)
		forn(j, 101)
			forn(r, 101)
				dp[i][j][r] = -1;

	ll ans = rec(0, -1, k);
	if (ans >= INF)
		printf("%d\n", -1);
	else
		cout << ans << endl;

	return 0;
}

ll rec(int idx, int prev, int remK)
{
	if (remK < 0)
		return INF;
	if (idx == n)
	{
	 	if (remK == 1)
			return 0;
		else
			return INF;
	}

	if (prev != -1 && dp[idx][prev][remK] != -1)
		return dp[idx][prev][remK];

	ll ans = INF;
	if (c[idx] > 0)
		ans = rec(idx+1, c[idx], c[idx] == prev || prev == -1 ? remK : remK-1);
	else
	{
		forn(i, m)
			ans = min(ans, rec(idx+1, i+1, (i+1) == prev || prev == -1 ? remK : remK-1) + p[idx][i]);
	}

	if (prev != -1)
		dp[idx][prev][remK] = ans;
	return ans;
}
