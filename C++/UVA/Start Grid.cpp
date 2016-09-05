#include <bits/stdc++.h>

using namespace std;

// Input macros
#define fast ios_base::sync_with_stdio(0);cin.tie(0);
#define s(n) int n; scanf("%d",&n)
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
#define first f
#define second s
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
	int n;
	while(scanf("%i",&n) != EOF)
	{
		int s[n];
		int e[n];
		int c[n+1];

		forn(i, n)
			scanf("%i",&s[i]);

		forn(i, n)
		{
			scanf("%i",&e[i]);
			c[e[i]] = i;
		}

		// print(c, n+1);

		int ans = 0;
		forr(i, n)
		{
			// cout << s[i] << " " << c[s[i]] << " " << i << endl;
			if (c[s[i]] > i)
			{
				int limit = c[s[i]];
				forall(j, i+1, limit+1, 1)
				{
					// cout << "j " << j << endl;
					int tmp = s[j-1];
					s[j-1]= s[j];
					s[j] = tmp;
					ans++;
					i = j-1;
				}
			}
			// print(s, n);
		}

		printf("%i\n", ans);
	}
}
