#ifndef SIMPLE_EXAMPLE_TETRIMINO_H
#define SIMPLE_EXAMPLE_TETRIMINO_H

#include "../Bitmap.h"

class Tetrimino {
protected:
    Bitmap* bitmap = 0;

    void load(bool** input, int width, int height);
public:
    Bitmap* getBitmap();

    int getWidth();
    int getHeight();

    virtual char getCode();

    void rotate();
};

#endif //SIMPLE_EXAMPLE_TETRIMINO_H
