#include<iostream>
#include<string>
#include<cstring>
#include<sstream>
#include<string.h>
#include<algorithm>
#include<cmath>
#include<cstdlib>
#include<vector>
#include<stdlib.h>
#include<set>
#include<stdio.h>
#define toInt(x) {atoi(x.c_str())};
#include<queue>
#include<map>

using namespace std;

int main()
{
    char letters[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    int t;
    scanf("%i",&t);

    while(t--)
    {
        map<string,int> dictionary;
        int count = 0;
        while(true)
        {
            string s;
            cin >> s;
            if (s.compare("*") == 0)
                break;
            dictionary[s] = count++;
        }
        string line;
        while(getline(cin,line) && !line.empty())
        {
        cout << line << endl;
        string src = "";
        string dest = "";
        int i = 0;
        for(; i < line.length(); i++)
        {
            if (line[i] == ' ')
                break;
            src += line[i];
        }
        i++;
        for(; i < line.length(); i++)
            dest += line[i];

        int dist[250];
        for(int i = 0; i < 250; i++)
            dist[i] = 0;

        queue<string> q;
        q.push(src);
        dist[dictionary.find(src)->second] = 0;

        while(!q.empty())
        {
            string parent = q.front();
            if (parent.compare(dest) == 0)
            {
                cout << src << " " << dest << " " << dist[dictionary.find(dest)->second] << endl;
                break;
            }
            q.pop();
            for(int i = 0; i < parent.length(); i++)
            {
                for(int j = 0; j < 26; j++)
                {
                    char r = letters[j];
                    if (r != parent[i])
                    {
                        string child = parent;
                        child[i] = r;
                        if (dictionary.find(child) != dictionary.end())
                        {
                            dist[dictionary.find(child)->second] = dist[dictionary.find(parent)->second] + 1;
                            q.push(child);
                        }
                    }
                }
            }
        }
        }
         if (t > 0)
            puts("");
    }
}
