#include <iostream>

using namespace std;
int diff(int a, int b) {
	if (a > b) return a - b;
	return b - a;
}
int prod(int n) {
	int res = 1;
	while (n > 0) {
		res *= n % 10;
		n = n / 10;
	}
	return res;
}
int sum(int n) {
	int res = 0;
	while (n > 0) {
		res += n % 10;
		n = n / 10;
	}
	return res;
}
int main(){
	int num;
	cout << "Enter the number: ";
	cin >> num;
	if (num > 0) {
		int summary = sum(num), product = prod(num);
		cout << summary << " " << product << " " << diff(summary, product);
	}
	else cout << "Number is not natural";
	return 0;
}