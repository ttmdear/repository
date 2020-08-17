#include "../../include/tetriminos/STetrimino.h"

STetrimino::STetrimino() {
    bool** bitmap = new bool*[2];

    bitmap[0] = new bool[3]{false,  true, true};
    bitmap[1] = new bool[3]{true,   true, false};

    load(bitmap, 3, 2);
}

char STetrimino::getCode() {
    return 'S';
}
