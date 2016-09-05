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

int main()
{
	ll n;
	cin >> n;

	if (n%2 != 0 && n > 1)
	{
		ll i = 3;
		ll c = 2;
		ll val = 1;
		for (; i < n; i+=2)
		{
			val += c;
			c++;
		}

		ll a = val*4;
		ll b = a+1;
		if (a > 0 && b > 0 && a <= 1000000000000000000 && b <= 1000000000000000000)
		{
			cout << a << " " << b << endl;
			return 0;
		}
	}

	for (ll i = 1; i * i < 10000000000; i++)
	{
		ll m2 = i*i - n;

		ll m = sqrt(m2);
		if (m*m != m2 || m >= i) continue;

		ll b = 2 * m * i;
		ll c = i*i + m2;

		if (b > 0 && c > 0 && b <= 1000000000000000000 && c <= 1000000000000000000)
		{
			cout << b << " " << c << endl;
			return 0;
		}
	}


	for (ll i = 1; i*i < 10000000000; i++)
	{
		ll m2 = n - i*i;

		ll m = sqrt(m2);

		if (m*m != m2 || m >= i) continue;

		ll a = i*i - m2;
		ll b = 2 * i * m;

		if (a > 0 && b > 0 && a <= 1000000000000000000 && b <= 1000000000000000000)
		{
			cout << a << " " << b << endl;
			return 0;
		}
	}

	for (ll i = 1; i < 50000000; i++)
	{
		if (n%(2*i) != 0) continue;

		ll m = n/(2*i);
		if (m >= i) continue;

		ll a = i*i - m*m;
		ll c = i*i + m*m;

		if (a > 0 && c > 0 && a <= 1000000000000000000 && c <= 1000000000000000000)
		{
			cout << a << " " << c << endl;
			return 0;
		}
	}

	cout << -1 << endl;
}