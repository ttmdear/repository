#ifndef GAME_BOARD_TETRISGAME_H
#define GAME_BOARD_TETRISGAME_H

#include <Display.h>
#include <GameController.h>
#include "games/Game.h"

class TetrisGame : public Game {
private:
    Display* display;
    GameController* gameController;
public:
    TetrisGame(Display* display, GameController* gameController);
};

#endif //GAME_BOARD_TETRISGAME_H
