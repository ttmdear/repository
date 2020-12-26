#ifndef GAME_BOARD_SPARINGMEMORY_H
#define GAME_BOARD_SPARINGMEMORY_H

#include <iostream>

struct BufferPointer;

class SparingMemory {
private:
    uint32_t *buffer;

    const uint8_t capacity;
    const uint8_t width;
    const uint8_t height;
    const uint8_t cellsNumber;

    uint8_t size;
    uint32_t baseMask;

    BufferPointer resolveBufferXY(const uint8_t &x, const uint8_t &y) const;

public:
    SparingMemory(uint8_t width, uint8_t height, uint8_t capacity);

    uint8_t get(const uint8_t &x, const uint8_t &y) const;

    void set(const uint8_t &x, const uint8_t &y, const uint8_t &value);

    virtual ~SparingMemory();

    void printBuffer();
};

struct BufferPointer {
    uint8_t x;
    uint8_t y;
};

#endif //GAME_BOARD_SPARINGMEMORY_H
