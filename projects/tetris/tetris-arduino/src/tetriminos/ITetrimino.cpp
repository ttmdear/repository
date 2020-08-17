#include "../../include/tetriminos/ITetrimino.h"

ITetrimino::ITetrimino() {
    bool** bitmap = new bool*[1];

    bitmap[0] = new bool[4]{true, true, true, true};

    load(bitmap, 4, 1);
}

char ITetrimino::getCode() {
    return 'I';
}