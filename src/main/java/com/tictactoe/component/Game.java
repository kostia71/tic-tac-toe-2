/*
 * Copyright (c) 2019. http://devonline.academy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tictactoe.component;

import com.tictactoe.model.GameTable;
import com.tictactoe.model.Player;

import java.util.Random;

/**
 * @author Kostya
 * @link https://github.com/kostia71/tic-tac-toe-2.git
 */
public class Game {

    private final boolean canSecondPlayerMakeFirstMove;

    private final DataPrinter dataPrinter;

    private final Player player1;

    private final Player player2;

    private final WinnerVerifier winnerVerifier;

    private final CellVerifier cellVerifier;

    public Game(boolean canSecondPlayerMakeFirstMove,
                DataPrinter dataPrinter,
                Player player1,
                Player player2,
                WinnerVerifier winnerVerifier,
                CellVerifier cellVerifier) {
        this.canSecondPlayerMakeFirstMove = canSecondPlayerMakeFirstMove;
        this.dataPrinter = dataPrinter;
        this.player1 = player1;
        this.player2 = player2;
        this.winnerVerifier = winnerVerifier;
        this.cellVerifier = cellVerifier;
    }

    public void play() {
        dataPrinter.printInfoMessage("Use the following mapping table to specify a cell using numbers from 1 to 9:");
        dataPrinter.printMappingTable();
        final GameTable gameTable = new GameTable();
        if (canSecondPlayerMakeFirstMove && new Random().nextBoolean()) {
            player2.makeMove(gameTable);
            dataPrinter.printGameTable(gameTable);
        }
        final Player[] players = {player1, player2};
        while (true) {
            for (Player player : players) {
                player.makeMove(gameTable);
                dataPrinter.printGameTable(gameTable);
                if (winnerVerifier.isWinner(gameTable, player)) {
                    dataPrinter.printInfoMessage(player + "WIN!");
                    printGamrOver();
                    return;
                }
                if (cellVerifier.allCellsFilled(gameTable)) {
                    dataPrinter.printInfoMessage("Sorry, DRAW!");
                    printGamrOver();
                    return;
                }
            }
        }
    }

    private void printGamrOver() {
        dataPrinter.printInfoMessage("GAME OVER!");
    }
}
