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
#define INF (int)2e9
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

const int dx[] = {-1,0,1, 0};
const int dy[] = { 0,1,0,-1};

int n, m;
bool valid(int i, int j);
int main()
{
	scanf("%i%i",&n,&m);
	char grid[n][m];
	forn(i, n)
	{
		forn(j, m)
		{
			scanf(" %c", &grid[i][j]);
		}
	}

	int maximum = 0;
	int ans[n][m];
	fill(ans, 0);
	forn(i, n)
	{
		forn(j, m)
		{
			if (grid[i][j] == 'T')
			{
				forn(k, 4)
				{
					int newI = i + dx[k];
					int newJ = j + dy[k];

					if ((valid(newI, newJ) && grid[newI][newJ] == '.') || !valid(newI, newJ))
					{
						ans[i][j] = 1;
						break;
					}
				}
				maximum = max(maximum, ans[i][j]);
			}
		}
	}

	forn(i, n)
	{
		forn(j, m)
		{
			if (ans[i][j] == 1)
				grid[i][j] = '.';
		}
	}

	int c = 1;
	while(true)
	{
		bool done = true;
		forn(i, n)
		{
			forn(j, m)
			{
				if (grid[i][j] == 'T')
				{
					done = false;
					forn(k, 4)
					{
						int newI = i + dx[k];
						int newJ = j + dy[k];

						if (ans[newI][newJ] == c)
						{
							ans[i][j] = c+1;
							break;
						}
					}
					maximum = max(maximum, ans[i][j]);

				}
			}
		}

		if (done) break;

		forn(i, n)
		{
			forn(j, m)
			{
				if (ans[i][j] == c+1)
					grid[i][j] = '.';
			}
		}

		c++;
	}

	forn(i, n)
	{
		forn(j, m)
		{
			if (ans[i][j] == 0)
			{
				printf("..");
				if (maximum >= 10)
					printf(".");
			}
			else
			{
				printf(".");
				if (ans[i][j] >= 10)
					printf("%i", ans[i][j]);
				else
				{
					if (maximum >= 10)
						printf(".");
					printf("%i", ans[i][j]);
				}
			}
		}

		puts("");
	}
}

bool valid(int i, int j)
{
	return i >= 0 && i < n && j >= 0 && j < m;
}