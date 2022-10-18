package com.tictactoe.component;

import com.tictactoe.model.GameTable;
import com.tictactoe.model.Sign;

/**
 * @author Kostya
 * @link https://github.com/kostia71/tic-tac-toe-2.git
 */
public interface ComputerMoveStrategy {

    boolean tryToMakeMove(GameTable gameTable, Sign sign);

}
