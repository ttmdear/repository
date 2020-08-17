#include <iostream>
#include "Bitmap.h"

Bitmap::Bitmap(char width, char height) {
    this->width = width;
    this->height = height;

    // Init
    bitmap = new bool*[height];

    for(char i = 0; i < height; i++) {
        bitmap[i] = new bool[width];

        for(char j = 0; j < width; j++) {
            bitmap[i][j] = false;
        }
    }
}

Bitmap::~Bitmap() {
    delete [] bitmap;
}

void Bitmap::load(bool** input, char width, char height) {
    load(input, width, height, 0, 0, false);
}

void Bitmap::load(bool** input, char width, char height, char x, char y, bool onlyHight) {
    for(char i = 0; i < height; i++) {
        for(char j = 0; j < width; j++) {
            if (onlyHight) {
                if (input[i][j]) {
                    bitmap[y + i][x + j] = true;
                }
            } else {
                bitmap[y + i][x + j] = input[i][j];
            }
        }
    }
}

void Bitmap::load(Bitmap *bitmap) {
    this->load(bitmap->getPointer(), bitmap->getWidth(), bitmap->getHeight(), 0, 0, false);
}

void Bitmap::load(Bitmap *bitmap, bool onlyHight) {
    this->load(bitmap->getPointer(), bitmap->getWidth(), bitmap->getHeight(), 0, 0, onlyHight);
}

char Bitmap::getWidth() {
    return width;
}

char Bitmap::getHeight() {
    return height;
}

bool** Bitmap::getPointer() {
    return bitmap;
}

void Bitmap::rotate() {
    bool** rotated = new bool*[width];

    for(char i=0; i < width; i++) {
        rotated[i] = new bool[height];

        for(char x=0; x < height; x++) {
            rotated[i][x] = false;
        }
    }

    for(int y=0;  y < width; y++) {
        for(int x=0; x < height; x++) {
            if (bitmap[(height - 1) - x][y]) {
                rotated[y][x] = true;
            } else {
                rotated[y][x] = false;
            }
        }
    }

    // Delete previous map
    for(char y=0; y < height; y++) {
        delete [] bitmap[y];
    }

    delete [] bitmap;

    // Assign new
    char n = height;

    height = width;
    width = n;

    bitmap = rotated;
}
