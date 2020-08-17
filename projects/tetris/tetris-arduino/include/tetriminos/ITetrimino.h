#ifndef SIMPLE_EXAMPLE_ITETRIMINO_H
#define SIMPLE_EXAMPLE_ITETRIMINO_H

#include "Tetrimino.h"

class ITetrimino : public Tetrimino {
public:
    ITetrimino();

    virtual char getCode();
};

#endif //SIMPLE_EXAMPLE_ITETRIMINO_H
