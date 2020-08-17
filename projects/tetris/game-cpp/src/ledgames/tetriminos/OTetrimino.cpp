//
// Created by thinkpad on 04.01.2020.
//

#include "OTetrimino.h"

OTetrimino::OTetrimino() {
    bool** bitmap = new bool*[2];

    bitmap[0] = new bool[2]{true,  true};
    bitmap[1] = new bool[2]{true,  true};

    load(bitmap, 2, 2);
}
