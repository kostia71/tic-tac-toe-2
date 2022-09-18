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

import com.tictactoe.component.keypad.DesktopNumericKeypadCellNumberConverter;
import com.tictactoe.model.Player;
import com.tictactoe.model.PlayerType;

import java.util.Locale;

import static com.tictactoe.model.PlayerType.COMPUTER;
import static com.tictactoe.model.PlayerType.USER;
import static com.tictactoe.model.Sign.O;
import static com.tictactoe.model.Sign.X;

/**
 * @author Kostya
 * @link https://github.com/kostia71/tic-tac-toe-2.git
 */
public class GameFactory {

    private final PlayerType playerType1;

    private final PlayerType playerType2;

    public GameFactory(String[] args) {
        PlayerType playerType1 = null;
        PlayerType playerType2 = null;
        for (String arg : args) {
            if (USER.name().equalsIgnoreCase(arg) || COMPUTER.name().equalsIgnoreCase(arg)) {
                if (playerType1 == null) {
                    playerType1 = PlayerType.valueOf(arg.toUpperCase(Locale.ROOT));
                } else if (playerType2 == null) {
                    playerType2 = PlayerType.valueOf(arg.toUpperCase());
                } else {
                    System.err.println("Unsupported command: '" + arg + "'");
                }
            } else {
                System.err.println("Unsupported command: '" + arg + "'");
            }
        }
        if (playerType1 == null) {
            this.playerType1 = USER;
            this.playerType2 = COMPUTER;
        } else if (playerType2 == null) {
            this.playerType1 = USER;
            this.playerType2 = playerType1;
        } else {
            this.playerType1 = playerType1;
            this.playerType2 = playerType2;
        }
    }


    public Game create() {
        final CellNumberConverter cellNumberConverter = new DesktopNumericKeypadCellNumberConverter();
        final Player player1;
        if (playerType1 == USER) {
            player1 = new Player(X, new UserMove(cellNumberConverter));
        } else {
            player1 = new Player(X, new ComputerMove());
        }
        final Player player2;
        if (playerType2 == USER) {
            player2 = new Player(O, new UserMove(cellNumberConverter));
        } else {
            player2 = new Player(O, new ComputerMove());
        }
        final boolean canSecondPlayerMakeFirstMove = playerType1 != playerType2;
        return new Game(
                canSecondPlayerMakeFirstMove,
                new DataPrinter(cellNumberConverter),
                player1,
                player2,
                new WinnerVerifier(),
                new CellVerifier()
        );
    }
}
