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

const int dx[] = {1,0,-1,0,1,1,-1,-1};
const int dy[] = {0,1,0,-1,1,-1,1,-1};

int n, m, l;
int a[4][4];
pair<int, int> b[16];
int dp[65540][18];

int rec(int msk, int k);
bool valid(int i, int j);
int main()
{
	s(t);
	forn(tc, t)
	{
		int k;
		scanf("%i%i%i",&n,&m,&k);

		int c = 0;
		forn(i, n)
		{
			forn(j, m)
			{
				a[i][j] = c;
				b[c++] = mp(i, j);
			}
		}
		l = c;

		int msk = 0;
		forn(i, k)
		{
			s(x);s(y);
			x--;y--;

			msk |= (1 << a[x][y]);
		}

		fill(dp, -1);
		printf("Case %i: %i\n", tc+1, rec(msk, k-1));
	}
}

int rec(int msk, int k)
{
	if (k == 0)
	{
		int c = 0;
		for (int i = 0; i < l; i++)
		{
			if ((msk & (1 << i)) != 0)
				c++;
		}

		return c == 1;
	}

	if (dp[msk][k] != -1)
		return dp[msk][k];

	int ans = 0;
	for (int i = 0; i < l; i++)
	{
		if ((msk & (1 << i)) != 0)
		{
			pair<int, int> p = b[i];

			forn(r, 8)
			{
				int newI = p.first + dx[r];
				int newJ = p.second + dy[r];

				if (valid(newI, newJ) && ((msk & (1 << a[newI][newJ])) != 0))
				{
					int otherI = newI + dx[r];
					int otherJ = newJ + dy[r];

					if (valid(otherI, otherJ) && ((msk & (1 << a[otherI][otherJ])) == 0))
					{
						int tmp = msk;
						tmp |= (1 << a[otherI][otherJ]);
						tmp &= ~(1 << i);
						tmp &= ~(1 << a[newI][newJ]);
						ans += rec(tmp , k-1);
					}
				}
			}
		}
	}

	return dp[msk][k] = ans;
}

bool valid(int i, int j)
{
	return i >= 0 && i < n && j >= 0 && j < m;
}