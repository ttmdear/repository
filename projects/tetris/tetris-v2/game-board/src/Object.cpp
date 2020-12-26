#include "Object.h"

Object::Object() {
    width = 3;
    height = 2;

    map = new uint8_t *[height];
    map[0] = new uint8_t[width]{0, 1, 0};
    map[1] = new uint8_t[width]{1, 1, 1};
}

uint8_t Object::getWidth() const {
    return width;
}

uint8_t Object::getHeight() const {
    return height;
}

uint8_t **Object::getMap() const {
    return map;
}

Object::~Object() {
    for (int y = 0; y < height; y++) {
        delete map[y];
    }

    delete map;
}

