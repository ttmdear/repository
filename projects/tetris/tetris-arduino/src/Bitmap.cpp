#include <HardwareSerial.h>
#include "../include/Bitmap.h"

Bitmap::Bitmap(int width, int height) {
    this->width = width;
    this->height = height;

    // Init
    bitmap = new bool*[height];

    for(int i = 0; i < height; i++) {
        bitmap[i] = new bool[width];

        for(int j = 0; j < width; j++) {
            bitmap[i][j] = false;
        }
    }
}

Bitmap::~Bitmap() {
    for(int i = 0; i < height; i++) {
        delete [] bitmap[i];
    }

    delete [] bitmap;
}

void Bitmap::load(bool** input, int width, int height) {
    load(input, width, height, 0, 0, false);
}

void Bitmap::load(bool** input, int width, int height, int x, int y, bool onlyHight) {
    for(int i = 0; i < height; i++) {
        for(int j = 0; j < width; j++) {
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

int Bitmap::getWidth() {
    return width;
}

int Bitmap::getHeight() {
    return height;
}

bool** Bitmap::getPointer() {
    return bitmap;
}

void Bitmap::rotate() {
    bool** rotated = new bool*[width];

    for(int i=0; i < width; i++) {
        rotated[i] = new bool[height];

        for(int x=0; x < height; x++) {
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
    for(int y=0; y < height; y++) {
        delete [] bitmap[y];
    }

    delete [] bitmap;

    // Assign new
    int n = height;

    height = width;
    width = n;

    bitmap = rotated;
}

void Bitmap::fill(bool value) {
    for(int y=0; y<height; y++) {
        for(int x=0; x<width; x++) {
            bitmap[y][x] = value;
        }
    }
}
