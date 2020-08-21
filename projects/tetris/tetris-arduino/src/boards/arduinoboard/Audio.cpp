//
// Created by thinkpad on 19.01.2020.
//
#include "../../../include/Audio.h"
#include <Arduino.h>

/**
 * "He's A Pirate" / "Pirates of the Caribbean" Theme Song Playing
 * By Xitang 2016.06.27
 * Youtube in Action: https://youtu.be/sjPAj1lXgtk
 *
 * INSTRUCTION: Hook up Pin 10 to the positive side of a buzzer or a microphone, hook up
 * any resistor to the negative side of a buzzer (to limit current & volume & to protect the pin),
 * and then connect the other end of the resistor to ground pin. Upload the sketch and enjoy!
 *
 * Music notes of the song obtained from Easy Music (Great website)
 * Link: http://easymusic.altervista.org/recorder-hes-a-pirate-pirates-of-caribbean-sheet-music-guitar-chords/
 *
 * Also would like to credit Musicnotes's "How to Read Sheet Music" Guide
 * Link: http://www.musicnotes.com/blog/2014/04/11/how-to-read-sheet-music/
 *
 * Code inspired by Chapter 5 of Jeremy Blum's book "Exploring Arduino"
 * Link: http://www.exploringarduino.com/content/ch5/
 *
 * Music notes' frequencies obtained from arduino website
 * Link: https://www.arduino.cc/en/Tutorial/toneMelody
 */

const int buzzer = 10; // Define pin 10, can use other PWM pins  (5,6 or 9)

// Note pins 3 and 11 can't be used when using the tone function in Arduino Uno

const int songspeed = 1.5; //Change to 2 for a slower version of the song, the bigger the number the slower the song

//*****************************************

#define NOTE_C4  262   //Defining note frequency
#define NOTE_D4  294
#define NOTE_E4  330
#define NOTE_F4  349
#define NOTE_G4  392
#define NOTE_A4  440
#define NOTE_B4  494
#define NOTE_C5  523
#define NOTE_D5  587
#define NOTE_E5  659
#define NOTE_F5  698
#define NOTE_G5  784
#define NOTE_A5  880
#define NOTE_B5  988

// Note of the song, 0 is a rest/pulse
int notes[] = {
    NOTE_E4, NOTE_G4, NOTE_A4, NOTE_A4, 0,
    NOTE_A4, NOTE_B4, NOTE_C5, NOTE_C5, 0,
    NOTE_C5, NOTE_D5, NOTE_B4, NOTE_B4, 0,
    NOTE_A4, NOTE_G4, NOTE_A4, 0,

    NOTE_E4, NOTE_G4, NOTE_A4, NOTE_A4, 0,
    NOTE_A4, NOTE_B4, NOTE_C5, NOTE_C5, 0,
    NOTE_C5, NOTE_D5, NOTE_B4, NOTE_B4, 0,
    NOTE_A4, NOTE_G4, NOTE_A4, 0,

    NOTE_E4, NOTE_G4, NOTE_A4, NOTE_A4, 0,
    NOTE_A4, NOTE_C5, NOTE_D5, NOTE_D5, 0,
    NOTE_D5, NOTE_E5, NOTE_F5, NOTE_F5, 0,
    NOTE_E5, NOTE_D5, NOTE_E5, NOTE_A4, 0,

    NOTE_A4, NOTE_B4, NOTE_C5, NOTE_C5, 0,
    NOTE_D5, NOTE_E5, NOTE_A4, 0,
    NOTE_A4, NOTE_C5, NOTE_B4, NOTE_B4, 0,
    NOTE_C5, NOTE_A4, NOTE_B4, 0,

    NOTE_A4, NOTE_A4,

    //Repeat of first part
    NOTE_A4, NOTE_B4, NOTE_C5, NOTE_C5, 0,
    NOTE_C5, NOTE_D5, NOTE_B4, NOTE_B4, 0,
    NOTE_A4, NOTE_G4, NOTE_A4, 0,

    // NOTE_E4, NOTE_G4, NOTE_A4, NOTE_A4, 0,
    // NOTE_A4, NOTE_B4, NOTE_C5, NOTE_C5, 0,
    // NOTE_C5, NOTE_D5, NOTE_B4, NOTE_B4, 0,
    // NOTE_A4, NOTE_G4, NOTE_A4, 0,

    // NOTE_E4, NOTE_G4, NOTE_A4, NOTE_A4, 0,
    // NOTE_A4, NOTE_C5, NOTE_D5, NOTE_D5, 0,
    // NOTE_D5, NOTE_E5, NOTE_F5, NOTE_F5, 0,
    // NOTE_E5, NOTE_D5, NOTE_E5, NOTE_A4, 0,

    // NOTE_A4, NOTE_B4, NOTE_C5, NOTE_C5, 0,
    // NOTE_D5, NOTE_E5, NOTE_A4, 0,
    // NOTE_A4, NOTE_C5, NOTE_B4, NOTE_B4, 0,
    // NOTE_C5, NOTE_A4, NOTE_B4, 0,
    // //End of Repeat

    // NOTE_E5, 0, 0, NOTE_F5, 0, 0,
    // NOTE_E5, NOTE_E5, 0, NOTE_G5, 0, NOTE_E5, NOTE_D5, 0, 0,
    // NOTE_D5, 0, 0, NOTE_C5, 0, 0,
    // NOTE_B4, NOTE_C5, 0, NOTE_B4, 0, NOTE_A4,

    // NOTE_E5, 0, 0, NOTE_F5, 0, 0,
    // NOTE_E5, NOTE_E5, 0, NOTE_G5, 0, NOTE_E5, NOTE_D5, 0, 0,
    // NOTE_D5, 0, 0, NOTE_C5, 0, 0,
    // NOTE_B4, NOTE_C5, 0, NOTE_B4, 0, NOTE_A4
};

// duration of each note (in ms) Quarter Note is set to 250 ms
int duration[] = {
    125, 125, 250, 125, 125,
    125, 125, 250, 125, 125,
    125, 125, 250, 125, 125,
    125, 125, 375, 125,

    125, 125, 250, 125, 125,
    125, 125, 250, 125, 125,
    125, 125, 250, 125, 125,
    125, 125, 375, 125,

    125, 125, 250, 125, 125,
    125, 125, 250, 125, 125,
    125, 125, 250, 125, 125,
    125, 125, 125, 250, 125,

    125, 125, 250, 125, 125,
    250, 125, 250, 125,
    125, 125, 250, 125, 125,
    125, 125, 375, 375,

    250, 125,
    // Rpeat of First Part
    125, 125, 250, 125, 125,
    125, 125, 250, 125, 125,
    125, 125, 375, 125,

    // 125, 125, 250, 125, 125,
    // 125, 125, 250, 125, 125,
    // 125, 125, 250, 125, 125,
    // 125, 125, 375, 125,

    // 125, 125, 250, 125, 125,
    // 125, 125, 250, 125, 125,
    // 125, 125, 250, 125, 125,
    // 125, 125, 125, 250, 125,

    // 125, 125, 250, 125, 125,
    // 250, 125, 250, 125,
    // 125, 125, 250, 125, 125,
    // 125, 125, 375, 375,
    // // End of Repeat

    // 250, 125, 375, 250, 125, 375,
    // 125, 125, 125, 125, 125, 125, 125, 125, 375,
    // 250, 125, 375, 250, 125, 375,
    // 125, 125, 125, 125, 125, 500,

    // 250, 125, 375, 250, 125, 375,
    // 125, 125, 125, 125, 125, 125, 125, 125, 375,
    // 250, 125, 375, 250, 125, 375,
    // 125, 125, 125, 125, 125, 500
};

Audio::Audio(int pinOut) {
    this->pinOut = pinOut;

    playing = false;
    times = -1;
}

void Audio::play(int sound) {
    playing = true;

    playingSoundPointer = 0;
    playingSoundWait = 0;
}

void Audio::playTimes(int sound, int times) {
    playing = true;

    this->times = times;

    playingSoundPointer = 0;
    playingSoundWait = 0;
}

void Audio::reload() {
    if (!playing) return;

    unsigned long time = millis();

    if (time < playingSoundWait) return;

    int wait = duration[playingSoundPointer] * songspeed;

    tone(pinOut, notes[playingSoundPointer], wait);

    playingSoundPointer++;

    if (playingSoundPointer >= 92) {
        playingSoundPointer = 0;

        if (times >= 0) {
            times--;

            if (times == -1) {
                playing = false;
            }
        }
    }

    playingSoundWait = time + wait;
}

bool Audio::isPlaying() {
    return playing;
}

void Audio::stopPlaying() {
    playing = false;
}