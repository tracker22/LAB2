#include <iostream>
#include <string>
#include <vector>

using namespace std;

int nulls(string s, int i) {
    while (s[i] == '0' and i < s.length()) {
        if (s[i + 1] == '1') return i + 1;
        else if (s[i + 1] != '0') return 0;
        i++;
    }
    return 0;
}
vector<string> findPattern(string s) {
    int last = 0, i = 0;
    vector<string> res;
    for (i; i < s.length(); i++) {
        if (s[i] == '1') {
            switch (s[i+1]){
            case '0':
                last = nulls(s, i + 1);
                if (last) {
                    res.push_back(s.substr(i, last + 1));
                    i = last;
                }
                break;
            case '1':
                last = nulls(s, i + 2);
                if (last) {
                    res.push_back(s.substr(i, last + 1));
                    i = last;
                }
                break;
            default:
                break;
            }
        }
    }
    return res;
}

int main(){
    string str = "1101gdyY101tf11flb1000";
    vector<string> v = findPattern(str);
    if (v.empty()) cout << "Not found";
    else for (int i = 0; i < v.size(); i++) cout << v[i] << ' ';
    return 0;
}