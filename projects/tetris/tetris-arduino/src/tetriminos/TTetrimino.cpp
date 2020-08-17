#include "../../include/tetriminos/TTetrimino.h"

TTetrimino::TTetrimino() {
    bool** bitmap = new bool*[2];

    bitmap[0] = new bool[3]{false, true, false};
    bitmap[1] = new bool[3]{true,  true, true};

    load(bitmap, 3, 2);
}

char TTetrimino::getCode() {
    return 'T';
}
