#include <iostream>
#include <vector>
#include <string>

using namespace std;
vector<string> findUnique(vector<string>& v) {
	int isUnique = 1;
	vector<string> unique;
	for (string i : v) {
		for (string j : unique) {
			if (j == i) isUnique = 0;
			continue;
		}
		if (isUnique) unique.push_back(i);
		isUnique = 1;
	}
	return unique;
}
void format(string& s) {
	auto iter = s.begin();
	while (*iter != '@') {
		if (*iter == '*') while (*iter != '@') iter = s.erase(iter); //удаляем символы после * 
		else if (*iter == '.') iter = s.erase(iter); //удаляем точки 
		else ++iter;
	}
}
int isAllowed(string s) {
	char notAllowedChars[] = { '&', '=', '+', '-', '_', '<', '>', ',', '\''};
	if (s[0] == '.') return 0; //точка не первая
	if (s.find('@') == string::npos) return 0;//есть собака
	int i = 0, count = 0;
	while (s[i] != '@') {//подсчет символов имени 
		count++;
		i++;
	}
	if (count < 6 or count > 30) return 0;// имя от 6 до 30 символов
	for (i = 0; i <= count; i++) {//проверка на запрещенные символы в имени
		for (char j : notAllowedChars) {
			if (s[i] == j) return 0;
		}
	}
	if (s.rfind('.') < s.find('@') or s.rfind('.') == string::npos) return 0; // есть точка в домене 
	return 1;
}

int main(){
	vector<string> v = { ".555555@.","1111.111@mail.ru","11111111@.mailru", "1111111@.mailru", "11111111@.mailru" };
	auto iter = v.begin();
	while (iter != v.end()) {
		if (isAllowed(*iter) == 0) iter = v.erase(iter);
		else {
			format(*iter);
			++iter;
		}
	}
	if (v.empty()) cout << "No unique emails";
	else {
		cout << findUnique(v).size() << endl;
	}
	return 0;
}