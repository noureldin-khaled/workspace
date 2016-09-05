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

int n, x, y;
int sum[32769];
int a[20];
char dp[101][32769];

char rec(int d, int m);
int main()
{
	int t = 1;
	while(true)
	{
		si(n);
		if (n == 0) break;
		printf("Case %i: ", t++);
		sii(x, y);

		int total = 0;
		forn(i, n)
		{
			si(a[i]);
			total += a[i];
		}

		if (x*y != total)
		{
			puts("No");
			continue;
		}

		fill(sum, 0);
		forn(i, n)
			sum[1 << i] = a[i];

		forall(i, 1, (1 << n), 1)
		{
			int lst = i & (-i);
			sum[i] = sum[lst] + sum[i ^ lst];
		}

		fill(dp, -1);
		if (rec(min(x, y), 0))
			puts("Yes");
		else
			puts("No");
	}
}

char rec(int d, int m)
{
	int msk = ((1 << n)-1) ^ m;

	if ((msk & (msk-1)) == 0) 
		return 1;

	if (dp[d][m] != -1)
		return dp[d][m];

	int d2 = sum[msk] / d;
	int msk1 = (msk-1)&msk, msk2 = msk1 ^ msk;

	char res = 0;
	while(msk1 > msk2 && res == 0)
	{
		if (sum[msk1]%d == 0 && sum[msk2]%d == 0)
			res |= (rec(d, m | msk1) & rec(d, m | msk2));
		if (res == 0 && sum[msk1]%d2 == 0 && sum[msk2]%d2 == 0)
			res |= (rec(sum[msk1]/d2, m | msk2) & rec(sum[msk2]/d2, m | msk1));

		msk1 = (msk1-1)&msk;
		msk2 = msk1 ^ msk;
	}

	return dp[d][m] = res;
}