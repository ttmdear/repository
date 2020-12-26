#include "SparingMemory.h"

BufferPointer SparingMemory::resolveBufferXY(const uint8_t &x, const uint8_t &y) const {
    // Function resolves the X,Y coordinate to X,Y inner buffer coordinate. Outer coordinate are bounded by width
    // and height. Inner coordinate are bounded with int size and buffer size.
    //      1    2    3    4    5    6    7    8
    // 1: 0000 0000 0000 0000 0000 0000 0000 0000
    // 2: 0000 0000 0000 0000 0000 0000 0000 0000
    // 3: 0000 0000 0000 0000 0000 0000 0000 0000
    // 4: 0000 0000 0000 0000 0000 0000 0000 0000

    // I calculate the number of memory chunk in buffer.
    uint16_t p = (y * width) + (x + 1);

    BufferPointer bp;

    // Divide p by numer of cells in row which gives me a Y value.
    bp.y = p / cellsNumber;

    // Check if there are no any other cells.
    uint16_t rest = p % cellsNumber;

    if (rest) {
        // If there are other cells, then I increase Y.
        //      1    2    3    4    5    6    7    8
        // 1: 0000 0000 0000 0000 0000 0000 0000 0000
        // 2: 0000 0000 0000 .... <-- value is here X
        // ^ This additional row.
        bp.y++;

        bp.x = rest;
    } else {
        // It is on last element.
        bp.x = cellsNumber;
    }

    // I decrease both X,Y to fit them for other operations.
    bp.y--;
    bp.x--;

    return bp;
}

void SparingMemory::printBuffer() {
    for (int y = 0; y < size; y++) {
        // 1000 0000 ...
        uint32_t mask = 0x80000000;
        const uint32_t v = buffer[y];

        for (int x = 0; x < 32; x++) {
            if (v & mask) {
                std::cout << "1";
            } else {
                std::cout << "0";
            }

            if ((x + 1) % capacity == 0) {
                std::cout << " ";
            }

            mask = mask >> 1;
        }

        std::cout << "\n";
    }
}

SparingMemory::~SparingMemory() {
    delete buffer;
}

void SparingMemory::set(const uint8_t &x, const uint8_t &y, const uint8_t &value) {
    BufferPointer bp = resolveBufferXY(x, y);

    const uint32_t mask = baseMask >> (bp.x * capacity);

    /**
     * Put zero values for specific element. First I set 1111 with OR operation, then I set 0000 with XOR operation.
     *
     * 0110 1010 0000
     * 0000 1111 0000 OR
     * --------------------
     * 0110 1111 0000
     * 0000 1111 0000 XOR
     * --------------------
     * 0110 0000 0000
     *      ^^^^
     */
    buffer[bp.y] = buffer[bp.y] | mask;
    buffer[bp.y] = buffer[bp.y] ^ mask;

    /**
     * The value is shift a calculated numer of places on right.
     */
    const uint32_t valueMask = value << ((cellsNumber - bp.x - 1) * capacity);

    buffer[bp.y] = buffer[bp.y] | valueMask;
}

SparingMemory::SparingMemory(uint8_t width, uint8_t height, uint8_t capacity) : width(width), height(height),
    capacity(capacity),
    cellsNumber(32 / capacity) {

    uint16_t rowSize = width * capacity;

    size = (rowSize / 32) * height;

    uint8_t rowSizeRest = rowSize % 32;

    if (rowSizeRest) {
        size = size + (rowSizeRest * height / 32) + 1;
    }

    buffer = new uint32_t[size];

    for (uint8_t y = 0; y < size; y++) {
        buffer[y] = 0;
    }

    baseMask = 0x80000000;

    for (uint8_t i = 1; i <= capacity; i++) {
        baseMask = baseMask >> 1;
        baseMask = baseMask | 0x80000000;
    }
}

uint8_t SparingMemory::get(const uint8_t &x, const uint8_t &y) const {
    BufferPointer bp = resolveBufferXY(x, y);

    // I calculate mask.
    uint32_t mask = baseMask >> (bp.x * capacity);

    uint32_t value = buffer[bp.y] & mask;

    // I change value to uint8_t
    return value >> (((cellsNumber - 1) - bp.x) * capacity);
}

