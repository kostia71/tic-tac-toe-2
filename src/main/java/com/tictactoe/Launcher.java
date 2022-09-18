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

package com.tictactoe;

import com.tictactoe.component.*;
import com.tictactoe.component.keypad.DesktopNumericKeypadCellNumberConverter;
import com.tictactoe.model.Player;

import static com.tictactoe.model.Sign.O;
import static com.tictactoe.model.Sign.X;

/**
 * @author Kostya
 * @link https://github.com/kostia71/tic-tac-toe-2.git
 */
public final class Launcher {

    public static void main(String[] args) {
        final CellNumberConverter cellNumberConverter = new DesktopNumericKeypadCellNumberConverter();
//        final CellNumberConverter cellNumberConverter = new TerminalNumericKeypadCellNumberConverter();
        final Game game = new Game(
                false,
                new DataPrinter(cellNumberConverter),
                new Player(X, new UserMove(cellNumberConverter)),
//                new Player(O,new UserMove(cellNumberConverter)),
//                new Player(X, new ComputerMove()),
                new Player(O, new ComputerMove()),
                new WinnerVerifier(),
                new CellVerifier()
        );
        game.play();
    }
}
