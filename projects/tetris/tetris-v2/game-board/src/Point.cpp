#include "Point.h"

Point::Point(uint8_t x, uint8_t y) : x(x), y(y) {}

uint8_t Point::getX() const {
    return x;
}

uint8_t Point::getY() const {
    return y;
}

