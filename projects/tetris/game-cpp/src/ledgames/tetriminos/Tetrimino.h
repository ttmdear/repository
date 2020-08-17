#ifndef SIMPLE_EXAMPLE_TETRIMINO_H
#define SIMPLE_EXAMPLE_TETRIMINO_H

#include "../Bitmap.h"

class Tetrimino {
protected:
    Bitmap* bitmap = 0;

    void load(bool** input, char width, char height);
public:
    Bitmap* getBitmap();

    char getWidth();
    char getHeight();

    virtual void rotate();
};

#endif //SIMPLE_EXAMPLE_TETRIMINO_H
