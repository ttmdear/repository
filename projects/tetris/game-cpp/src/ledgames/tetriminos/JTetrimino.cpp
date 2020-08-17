//
// Created by thinkpad on 04.01.2020.
//

#include "JTetrimino.h"

JTetrimino::JTetrimino() {
    bool** bitmap = new bool*[3];

    bitmap[0] = new bool[2]{false, true};
    bitmap[1] = new bool[2]{false, true};
    bitmap[2] = new bool[2]{true, true};

    load(bitmap, 2, 3);
}
