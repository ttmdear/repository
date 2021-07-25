#include <iostream>


class Counter {
private:
    int value = 0;
public:
    Counter() {
        std::cout << "Counter()" << std::endl;
    }

    explicit Counter(int value) {
        std::cout << "Counter(int value)" << std::endl;
    }

    // Counter(double value) {
    //     std::cout << "Counter(double value)" << std::endl;
    // }

    // Counter(Counter& counter) {
    //     std::cout << "Counter(Counter& counter)" << std::endl;
    // }

    // Counter& operator =(const Counter& counter) {
    //     std::cout << "Counter& operator =(const Counter& counter)" << std::endl;

    //     return * this;
    // }
    
    Counter& operator =(int value) {
        std::cout << "Counter& operator =(int value)" << std::endl;

        return * this;
    }
};

int main() {
    Counter c1(10);

    // c1 = 10;

    // Counter c1;
    // Counter c2 = c1;

    // Wyjście
    // Counter()
    // Counter(Counter& counter)

    // Counter c3 = 20;
    // c3 = 10;

    // Counter c4 = 3.123;
    // Counter c5 = c1;
}
