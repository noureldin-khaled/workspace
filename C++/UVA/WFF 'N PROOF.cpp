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

const char a[] = {'K', 'A', 'N', 'C', 'E', 'p', 'q', 'r', 's', 't'};

int main()
{
	fast 

	map<char, int> m;
	forn(i, 10)
		m[a[i]] = i;

	while(true)
	{
		string s;
		cin >> s;

		if (s.compare("0") == 0) break;
		int n = s.length();

		int occ[10];
		fill(occ, 0);
		forn(i, n)
			occ[m.find(s[i])->second]++;

		string ans = "";
		forall(i, 5, 10, 1)
		{
			if (occ[i] > 0)
			{
				ans += a[i];
				occ[i]--;
				break;
			}
		}

		if (ans.empty()) 
		{
			cout << "no WFF possible" << endl;
			continue;
		}


		while (occ[2]--)
			ans = "N" + ans;

		queue<char> q1;
		queue<char> q2;

		forn (i, 5)
		{
			forn(j, occ[i])
				q1.push(a[i]);
		}

		forall(i, 5, 10, 1)
		{
			forn(j, occ[i])
				q2.push(a[i]);
		}

		while(!q1.empty() && !q2.empty())
		{
			char c1 = q1.front();q1.pop();
			char c2 = q2.front();q2.pop();

			ans = c1 + ans + c2;
		}

		cout << ans << endl;
	}
}