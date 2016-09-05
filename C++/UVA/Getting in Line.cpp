#include <bits/stdc++.h>

using namespace std;

// Input macros
#define fast ios_base::sync_with_stdio(0);cin.tie(0);
#define s(n) int n; scanf("%d",&n)
#define sc(n) char n; scanf(" %c",&n)
#define sl(n) long long n; scanf("%lld",&n)
#define sd(n) double n; scanf("%lf",&n)
#define ss(n, sz) char str[sz]; scanf("%s",str); string n = str
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

double dist(pair<int, int> p, pair<int, int> q);
double sq(double n);
int main()
{
	int t = 1;
	while(true)
	{
		s(n);
		if (n == 0) break;
		pair<int, int> a[n];
		forn(i, n)
		{
			s(x);s(y);
			a[i] = mp(x, y);
		}

		sort(a, a+n);
		double minimum = INF;
		pair<int, int> ans[n];
		do
		{
			double cur = 0.0;
			forn(i, n-1)
			{
				cur += dist(a[i], a[i+1])+16;
			}

			if (cur < minimum)
			{
				minimum = cur;
				forn(i, n)
				{
					ans[i] = mp(a[i].first, a[i].second);
				}
			}
		}while(next_permutation(a, a+n));

		puts("**********************************************************");
		printf("Network #%i\n", t++);
		forn(i, n-1)
		{
			printf("Cable requirement to connect (%i,%i) to (%i,%i) is %.2f feet.\n", ans[i].first, ans[i].second, ans[i+1].first, ans[i+1].second, dist(ans[i],ans[i+1])+16);
		}
		printf("Number of feet of cable required is %.2f.\n", minimum);
	}
}

double dist(pair<int, int> p, pair<int, int> q)
{
	return sqrt(sq(p.first-q.first) + sq(p.second-q.second));
}

double sq(double n)
{
	return n*n;
}