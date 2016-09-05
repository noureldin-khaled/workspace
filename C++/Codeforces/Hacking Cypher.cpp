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
	string s;
	cin >> s;
	int n = s.length();

	s(a);s(b);

	int l[n];
	int r[n];

	int m = 0;

	forn(i, n)
	{
		int digit = s[i]-'0';
		l[i] = (m + digit%a)%a;
		m = (l[i] * 10%a)%a;
	}

	m = 0;
	ll t = 1;

	forr(i, n)
	{
		int digit = s[i]-'0';
		r[i] = ((digit%b * t%b)%b + m)%b;
		m = r[i];
		t = (t%b * 10%b)%b;
	}

	int idx = -1;
	forn(i, n-1)
	{
		if (l[i] == 0 && r[i+1] == 0 && s[i+1] != '0')
		{
			idx = i;
			break;
		}
	}

	if (idx == -1)
		puts("NO");
	else
	{
		puts("YES");
		forn(i, idx+1)
		{
			printf("%c", s[i]);
		}

		puts("");
		forall(i, idx+1, n, 1)
		{
			printf("%c", s[i]);
		}

		puts("");
	}

	// print(l, n);
	// print(r, n);
}

