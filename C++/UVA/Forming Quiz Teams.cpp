#include <bits/stdc++.h>

using namespace std;

// Input macros
#define fast ios_base::sync_with_stdio(0);cin.tie(0);
#define s(n) int n; scanf("%d",&n)
#define sc(n) char n; scanf(" %c",&n)
#define sl(n) long long n; scanf("%I64d",&n)
#define sd(n) double n; scanf("%lf",&n)
#define read(s) freopen(s, "r", stdin)
#define write(s) freopen(s, "w", stdout);

// Useful constants
#define INF 2e9
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

int n, d;
pair<int, int> a[20];
double dp[100000];

double dist(pair<int, int> p1, pair<int, int> p2);
double sq(double n);
double rec(int msk);
int power(int a, int e);
int main()
{
	int t = 1;
	while(true)
	{
		scanf("%i",&n);
		if (n == 0) break;

		n *= 2;
		forn(i, n)
		{
			string s;
			cin >> s;
			s(x);s(y);

			a[i] = mp(x, y);
		}

		d = power(2, n)-1;
		for (int i = 0; i < 100000; i++)
			dp[i] = -1;

		printf("Case %i: %.2f\n", t++, rec(0));
	}
}

int power(int a, int e)
{
	int res = 1;
	while(e > 0)
	{
		if((e & 1) == 1)
			res *= a;
		a *= a;
		e >>= 1;
	}
	return res;
}

double rec(int msk)
{
	if (msk == d)
		return 0.0;

	if (dp[msk] != -1)
		return dp[msk];

	double res = INF;
	for (int i = 0; i < n; i++)
	{
		if ((msk & (1 << i)) == 0)
		{
			for (int j = 0; j < n; j++)
			{
				if (i == j) continue;

				if ((msk & (1 << j)) == 0)
				{
					res = min(res, dist(a[i], a[j]) + rec(msk | (1 << i) | (1 << j)));
				}
			}
		}
	}

	return dp[msk] = res;
}

double dist(pair<int, int> p1, pair<int, int> p2)
{
	return sqrt(sq(p1.first - p2.first) + sq(p1.second - p2.second));
}

double sq(double n)
{
	return n*n;
}