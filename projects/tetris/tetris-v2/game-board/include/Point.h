#ifndef GAME_BOARD_POINT_H
#define GAME_BOARD_POINT_H

#include <iostream>

class Point {
private:
    uint8_t x;
    uint8_t y;
public:
    Point(uint8_t x, uint8_t y);

    uint8_t getX() const;

    uint8_t getY() const;
};

#endif //GAME_BOARD_POINT_H
