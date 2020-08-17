#ifndef SIMPLE_EXAMPLE_BITMAP_H
#define SIMPLE_EXAMPLE_BITMAP_H

/**
 * Bitmap
 */
class Bitmap {
private:
    int width;
    int height;
    bool** bitmap;
public:
    Bitmap(int width, int height);
    ~Bitmap();

    bool** getPointer();

    void load(bool** input, int width, int height);
    void load(Bitmap* bitmap);

    int getWidth();
    int getHeight();

    void load(bool **input, int width, int height, bool onlyHight);

    void load(Bitmap *bitmap, bool onlyHight);

    void load(bool **input, int width, int height, int x, int y, bool onlyHight);

    void fill(bool value);

    void rotate();
};

#endif //SIMPLE_EXAMPLE_BITMAP_H
