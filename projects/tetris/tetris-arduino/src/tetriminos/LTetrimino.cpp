#include "../../include/tetriminos/LTetrimino.h"

LTetrimino::LTetrimino() {
    bool** bitmap = new bool*[3];

    bitmap[0] = new bool[2]{true,  false};
    bitmap[1] = new bool[2]{true,  false};
    bitmap[2] = new bool[2]{true,  true};

    load(bitmap, 2, 3);
}

char LTetrimino::getCode() {
    return 'L';
}
