//
// Created by thinkpad on 04.01.2020.
//

#include "LTetrimino.h"

LTetrimino::LTetrimino() {
    bool** bitmap = new bool*[3];

    bitmap[0] = new bool[2]{true,  false};
    bitmap[1] = new bool[2]{true,  false};
    bitmap[2] = new bool[2]{true,  true};

    load(bitmap, 2, 3);
}
