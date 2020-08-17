#ifndef TETRIS_ARDUINO_AUDIO_H
#define TETRIS_ARDUINO_AUDIO_H

#include "board.h"

class Audio {
private:
    bool playing;
    unsigned long playingSoundWait;
    int playingSoundPointer;
    int times;
#ifdef BOARD_ARDUINO
    int pinOut;
#endif

public:
    static const int SOUND_INTRO;
#ifdef BOARD_ARDUINO
    Audio(int pinOut);
#endif
    void play(int sound);
    void playTimes(int sound, int times);
    void reload();
    bool isPlaying();

    void stopPlaying();
};

#endif //TETRIS_ARDUINO_AUDIO_H
