#include <bits/stdc++.h>

using namespace std;

// Input macros
#define fast ios_base::sync_with_stdio(0);cin.tie(0);
#define sn(n) scanf("%d",&n)
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

int n;

const int dx[] = {-1,0,1, 0};
const int dy[] = { 0,1,0,-1};

bool valid(int i, int j);
int main()
{
	int t;
	sn(t);

	forn(c, t)
	{
		sn(n);
		char grid[n][n];
		forn(i, n)
			forn(j, n)
				scanf(" %c", &grid[i][j]);

		forn(i, n)
		{
			forn(j, n)
			{
				if (grid[i][j] == '.')
				{
					forn(r, 26)
					{
						char c = (char)(r + 'A');
						bool canPlace = true;
						forn(k, 4)
						{
							int newI = i + dx[k];
							int newJ = j + dy[k];

							if (valid(newI, newJ) && grid[newI][newJ] == c)
							{
								canPlace = false;
								break;
							}
						}

						if (canPlace)
						{
							grid[i][j] = c;
							break;
						}
					}
				}
			}
		}

		printf("Case %i:\n", c+1);
		forn(i, n)
		{
			forn(j, n)
				cout << grid[i][j];
			cout << endl;
		}
	}
}

bool valid(int i, int j)
{
	return i >= 0 && i < n && j >= 0 && j < n;
}