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

const int dx[] = {-1,-1,1,1};
const int dy[] = {-1,1,1,-1};

int n;
int canPlace[2001][2001];

bool valid(ii p);
void dfs(int i, int j);
int main()
{
	scanf("%i",&n);
	int a[n][n];

	forn(i, n)
		forn(j, n)
			scanf("%i",&a[i][j]);

	ll Dleft[n][n];
	bool flag = false;
	int i = 1;
	ii st = mp(0, n-i);
	forn(c, 2*n-1)
	{
		ll sum = 0;
		ii tmp = mp(st.f, st.s);
		while(valid(st))
		{
			sum += a[st.f][st.s];
			st = mp(st.f+1, st.s+1);
		}

		while(valid(tmp))
		{
			Dleft[tmp.f][tmp.s] = sum;
			tmp = mp(tmp.f+1, tmp.s+1);
		}
		i++;
		if (flag)
			st = mp(i, 0);
		else
		{
			st = mp(0, n-i);
			if (!valid(st))
			{
				flag = true;
				i = 1;
				st = mp(i, 0);
			}
		}
	}

	ll Dright[n][n];
	flag = false;
	i = 0;
	st = mp(0, i);
	forn(c, 2*n-1)
	{
		ll sum = 0;
		ii tmp = mp(st.f, st.s);
		while(valid(st))
		{
			sum += a[st.f][st.s];
			st = mp(st.f+1, st.s-1);
		}

		while(valid(tmp))
		{
			Dright[tmp.f][tmp.s] = sum;
			tmp = mp(tmp.f+1, tmp.s-1);
		}

		i++;
		if (flag)
			st = mp(i, n-1);
		else
		{
			st = mp(0, i);
			if (!valid(st))
			{
				flag = true;
				i = 1;
				st = mp(i, n-1);
			}
		}
	}

	ii p1 = mp(-1, -1);
	ll maximum1 = -1;
	forn(i, n)
	{
		forn(j, n)
		{
			if (Dleft[i][j] + Dright[i][j] - a[i][j] > maximum1)
			{
				maximum1 = Dleft[i][j] + Dright[i][j] - a[i][j];
				p1 = mp(i, j);	
			}
		}
	}

	
	fill(canPlace, 1);
	dfs(p1.f, p1.s);

	flag = false;
	i = 1;
	st = mp(0, n-i);
	forn(c, 2*n-1)
	{
		ll sum = 0;
		ii tmp = mp(st.f, st.s);
		while(valid(st))
		{
			sum += a[st.f][st.s];
			st = mp(st.f+1, st.s+1);
		}

		while(valid(tmp))
		{
			Dleft[tmp.f][tmp.s] = sum;
			tmp = mp(tmp.f+1, tmp.s+1);
		}
		i++;
		if (flag)
			st = mp(i, 0);
		else
		{
			st = mp(0, n-i);
			if (!valid(st))
			{
				flag = true;
				i = 1;
				st = mp(i, 0);
			}
		}
	}

	flag = false;
	i = 0;
	st = mp(0, i);
	forn(c, 2*n-1)
	{
		ll sum = 0;
		ii tmp = mp(st.f, st.s);
		while(valid(st))
		{
			sum += a[st.f][st.s];
			st = mp(st.f+1, st.s-1);
		}

		while(valid(tmp))
		{
			Dright[tmp.f][tmp.s] = sum;
			tmp = mp(tmp.f+1, tmp.s-1);
		}

		i++;
		if (flag)
			st = mp(i, n-1);
		else
		{
			st = mp(0, i);
			if (!valid(st))
			{
				flag = true;
				i = 1;
				st = mp(i, n-1);
			}
		}
	}

	ii p2 = mp(-1, -1);
	ll maximum2 = -1;
	forn(i, n)
	{
		forn(j, n)
		{
			if (Dleft[i][j] + Dright[i][j] - a[i][j] > maximum2 && canPlace[i][j])
			{
				maximum2 = Dleft[i][j] + Dright[i][j] - a[i][j];
				p2 = mp(i, j);	
			}
		}
	}

	cout << maximum1 + maximum2 << endl;
	printf("%i %i %i %i\n", p1.f+1, p1.s+1, p2.f+1, p2.s+1);
}

void dfs(int i, int j)
{
	canPlace[i][j] = 0;

	forn(k, 4)
	{
		int newI = i+dx[k];
		int newJ = j+dy[k];

		if (valid(mp(newI, newJ)) && canPlace[newI][newJ])
			dfs(newI, newJ);
	}
}

bool valid(ii p)
{
	return p.f >= 0 && p.f < n && p.s >= 0 && p.s < n;
}