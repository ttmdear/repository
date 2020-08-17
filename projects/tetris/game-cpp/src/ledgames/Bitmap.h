#ifndef SIMPLE_EXAMPLE_BITMAP_H
#define SIMPLE_EXAMPLE_BITMAP_H

/**
 * Bitmap
 */
class Bitmap {
private:
    char width;
    char height;
    bool** bitmap;
public:
    Bitmap(char width, char height);
    ~Bitmap();

    bool** getPointer();

    void load(bool** input, char width, char height);
    void load(Bitmap* bitmap);

    char getWidth();
    char getHeight();

    void load(bool **input, char width, char height, bool onlyHight);

    void load(Bitmap *bitmap, bool onlyHight);

    void load(bool **input, char width, char height, char x, char y, bool onlyHight);

    void rotate();
};

#endif //SIMPLE_EXAMPLE_BITMAP_H
