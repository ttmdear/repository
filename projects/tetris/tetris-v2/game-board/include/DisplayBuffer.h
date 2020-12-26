#ifndef GAME_BOARD_DISPLAYBUFFER_H
#define GAME_BOARD_DISPLAYBUFFER_H

#include <iostream>
#include "Object.h"
#include "Point.h"

class DisplayBuffer {
private:
    uint32_t *buffer;
    uint8_t height;
    uint8_t width;
public:
    DisplayBuffer(const uint8_t height);

    void putIn(const Object &object, const Point &point);

    uint8_t getHeight() const;

    uint8_t getWidth() const;

    void printBuffer();

    void clean();
};

#endif //GAME_BOARD_DISPLAYBUFFER_H
