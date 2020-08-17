#include <stddef.h>
#include "../../include/tetriminos/Tetrimino.h"

Bitmap* Tetrimino::getBitmap() {
    return bitmap;
}

void Tetrimino::load(bool **input, int width, int height) {
    if (bitmap != 0) delete bitmap;

    bitmap = new Bitmap(width, height);
    bitmap->load(input, width, height);
}

int Tetrimino::getWidth() {
    if (bitmap == NULL) return 0;

    return bitmap->getWidth();
}

int Tetrimino::getHeight() {
    if (bitmap == NULL) return 0;

    return bitmap->getHeight();
}

void Tetrimino::rotate() {
    this->bitmap->rotate();
}

char Tetrimino::getCode() {
    return 'W';
}

