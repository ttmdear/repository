//
// Created by thinkpad on 04.01.2020.
//

#include "ZTetrimino.h"

ZTetrimino::ZTetrimino() {
    bool** bitmap = new bool*[2];

    bitmap[0] = new bool[3]{true,   true, false};
    bitmap[1] = new bool[3]{false,  true, true};

    load(bitmap, 3, 2);
}
