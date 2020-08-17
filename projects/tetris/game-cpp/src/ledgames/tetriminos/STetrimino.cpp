//
// Created by thinkpad on 04.01.2020.
//

#include "STetrimino.h"

STetrimino::STetrimino() {
    bool** bitmap = new bool*[2];

    bitmap[0] = new bool[3]{false,  true, true};
    bitmap[1] = new bool[3]{true,   true, false};

    load(bitmap, 3, 2);
}
