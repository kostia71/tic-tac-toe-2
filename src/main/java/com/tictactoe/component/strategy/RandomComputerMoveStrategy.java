package com.tictactoe.component.strategy;

import com.tictactoe.component.ComputerMoveStrategy;
import com.tictactoe.model.Cell;
import com.tictactoe.model.GameTable;
import com.tictactoe.model.Sign;

import java.util.Random;

/**
 * @author Kostya
 * @link https://github.com/kostia71/tic-tac-toe-2.git
 */
public class RandomComputerMoveStrategy implements ComputerMoveStrategy {

    @Override
    public boolean tryToMakeMove(GameTable gameTable, Sign sign) {
         final Cell[] emptyCells = new Cell[9];
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final Cell cell = new Cell(i, j);
                if (gameTable.isEmpty(cell)) {
                    emptyCells[count++] = cell;
                }
            }
        }
        if (count > 0) {
            final Cell randomCell = emptyCells[new Random().nextInt(count)];
            gameTable.setSign(randomCell, sign);
            return true;
        } else {
            throw new IllegalArgumentException("Game table does not contain any empty cell");
        }
    }
}
