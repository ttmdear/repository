#ifndef GAME_BOARD_OBJECT_H
#define GAME_BOARD_OBJECT_H

#include <iostream>

class Object {
private:
    uint8_t width;
    uint8_t height;
private:
    uint8_t **map;
public:
    Object();

    uint8_t getWidth() const;

    uint8_t getHeight() const;

    uint8_t **getMap() const;

    virtual ~Object();
};

#endif //GAME_BOARD_OBJECT_H
