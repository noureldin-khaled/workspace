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
#define INF 1e16
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

#define MAX 2050

int m, n;
int a[MAX];
int dp[MAX][MAX];

int rec(int questions, int answers);
int main()
{
	while(true)
	{
		sii(m, n);

		if (m + n == 0) break;
		forn(i, n)
		{
			string s;
			cin >> s;

			int cur = 0;

			forn(j, m)
			{
				if (s[j] == '1')
					cur |= (1 << (m-1-j));
			}
			a[i] = cur;
		}

		fill(dp, -1);
		printf("%i\n", rec(0, 0));
	}
}

int rec(int questions, int answers)
{
	if (dp[questions][answers] != -1)
		return dp[questions][answers];

	int r = 0;
	forn(i, n)
	{
		if ((questions & a[i]) == answers)
			r++;
	}

	if (r < 2)
		return dp[questions][answers] = 0;

	int res = 100;
	forn(i, m)
	{
		if ((questions & (1 << i)) == 0)
			res = min(res, 1 + max(rec(questions | 1 << i, answers | 1 << i), rec(questions | 1 << i, answers)));
	}

	return dp[questions][answers] = res;
}