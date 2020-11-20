#include <bits/stdc++.h>

using namespace std;
int main() {

    // m의 배수의 합
    int n, m, i, sum=0;

    // console 을 통해서 값을 받는다
    cin>>n>>m;

    for (i =1; i <= n; i++) {
        if (i %m ==0) {
            sum += i;
        }
    }
    cout << "hello world!" << endl;
    return 0;
}