#include "DisplayBuffer.h"

DisplayBuffer::DisplayBuffer(const uint8_t height) {
    this->width = 32;
    this->height = height;

    buffer = new uint32_t[height];

    clean();
}

void DisplayBuffer::putIn(const Object &object, const Point &point) {
    uint8_t objectHeight = object.getHeight();
    uint8_t objectWidth = object.getWidth();
    uint8_t **objectMap = object.getMap();
    uint8_t pointX = point.getX();
    uint8_t pointY = point.getY();

    uint32_t objectBuffer[object.getHeight()];

    for (uint8_t y = 0; y < objectHeight; y++) {
        objectBuffer[y] = 0x00000000;
        uint32_t mask = 0x80000000;

        for (uint8_t x = 0; x < objectWidth; x++) {
            if (objectMap[y][x]) {
                objectBuffer[y] = objectBuffer[y] | mask;
            }

            mask = mask >> 1;
        }

        objectBuffer[y] = objectBuffer[y] >> pointX;
    }

    // Put object in buffer.
    uint8_t index;
    for (uint8_t y = 0; y < objectHeight; y++) {
        index = y + pointY;

        buffer[index] = buffer[index] | objectBuffer[y];
    }
}

uint8_t DisplayBuffer::getHeight() const {
    return height;
}

void DisplayBuffer::printBuffer() {
    for (int y = 0; y < height; y++) {
        // 1000 0000 ...
        uint32_t mask = 0x80000000;
        const uint32_t v = buffer[y];

        for (int x = 0; x < width; x++) {
            if (v & mask) {
                std::cout << "1";
            } else {
                std::cout << "0";
            }

            mask = mask >> 1;
        }

        std::cout << "\n";
    }
}

void DisplayBuffer::clean() {
    for (uint8_t i = 0; i < height; i++) {
        buffer[i] = 0;
    }
}

uint8_t DisplayBuffer::getWidth() const {
    return width;
}
