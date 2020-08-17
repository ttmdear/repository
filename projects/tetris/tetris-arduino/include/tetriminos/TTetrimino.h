#ifndef SIMPLE_EXAMPLE_TTETRIMINO_H
#define SIMPLE_EXAMPLE_TTETRIMINO_H

#include "Tetrimino.h"

class TTetrimino : public Tetrimino {
public:
    TTetrimino();

    virtual char getCode();
};

#endif //SIMPLE_EXAMPLE_TTETRIMINO_H
