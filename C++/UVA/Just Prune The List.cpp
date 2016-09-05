#include <bits/stdc++.h>

using namespace std;

// Input macros
#define fast ios_base::sync_with_stdio(0);cin.tie(0);
#define sn(n) int n; scanf("%d",&n)
#define sc(n) char n; scanf(" %c",&n)
#define sd(n) double n; scanf("%lf",&n)
#define read(s) freopen(s, "r", stdin)
#define write(s) freopen(s, "w", stdout);

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

int main()
{
	sn(t);
	while(t--)
	{
		sn(n);sn(m);

		map<int, int> m1;
		map<int, int> m2;

		int a[n];
		forn(i, n)
		{
			sn(num);
			a[i] = num;
			map<int, int>::iterator  it = m1.find(num);
			if (it != m1.end())
				it->second++;
			else
				m1[num] = 1;
		}

		int b[m];
		forn(i, m)
		{
			sn(num);
			b[i] = num;
			map<int, int>::iterator it = m2.find(num);
			if (it != m2.end())
				it->second++;
			else
				m2[num] = 1;
		}

		int ans = 0;
		forn(i, n)
		{
			int num = a[i];
			map<int, int>::iterator  it = m2.find(num);
			if (it == m2.end() || it->second == 0)
				ans++;
			else
				it->second--;
		}
		
		forn(i, m)
		{
			int num = b[i];
			map<int, int>::iterator  it = m1.find(num);
			if (it == m1.end() || it->second == 0)
				ans++;
			else
				it->second--;
		}

		printf("%i\n", ans);		
	}
}
