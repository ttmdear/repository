#ifndef SIMPLE_EXAMPLE_LTETRIMINO_H
#define SIMPLE_EXAMPLE_LTETRIMINO_H

#include "Tetrimino.h"

class LTetrimino : public Tetrimino {

public:
    LTetrimino();

    virtual char getCode();
};

#endif //SIMPLE_EXAMPLE_LTETRIMINO_H
