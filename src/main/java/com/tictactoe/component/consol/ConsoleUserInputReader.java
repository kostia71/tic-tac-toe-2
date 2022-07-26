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

package com.tictactoe.component.consol;

import com.tictactoe.component.CellNumberConverter;
import com.tictactoe.component.DataPrinter;
import com.tictactoe.component.UserInputReader;
import com.tictactoe.model.Cell;

import java.util.Scanner;

/**
 * @author Kostya
 * @link https://github.com/kostia71/tic-tac-toe-2.git
 */
public class ConsoleUserInputReader implements UserInputReader {

    private final CellNumberConverter cellNumberConverter;

    private final DataPrinter dataPrinter;

    public ConsoleUserInputReader(final CellNumberConverter cellNumberConverter,
                                  final DataPrinter dataPrinter) {
        this.cellNumberConverter = cellNumberConverter;
        this.dataPrinter = dataPrinter;
    }

    @Override
    public Cell getUserInput() {
        while (true) {
            dataPrinter.printInfoMessage("Please type number between 1 and 9:");
            final String userInput = new Scanner(System.in).nextLine();
            if (userInput.length() == 1) {
                final char ch = userInput.charAt(0);
                if (ch >= '1' && ch <= '9') {
                    return cellNumberConverter.toCell(ch);
                }
            }
        }
    }
}