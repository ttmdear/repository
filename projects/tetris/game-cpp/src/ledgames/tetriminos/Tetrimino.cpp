#include "Tetrimino.h"

Bitmap* Tetrimino::getBitmap() {
    return bitmap;
}

void Tetrimino::load(bool **input, char width, char height) {
    if (bitmap != 0) delete bitmap;

    bitmap = new Bitmap(width, height);
    bitmap->load(input, width, height);
}

char Tetrimino::getWidth() {
    if (bitmap == 0) return 0;

    return bitmap->getWidth();
}

char Tetrimino::getHeight() {
    if (bitmap == 0) return 0;

    return bitmap->getHeight();
}

void Tetrimino::rotate() {
    this->bitmap->rotate();
}

