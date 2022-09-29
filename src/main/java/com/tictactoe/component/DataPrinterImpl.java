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

import com.tictactoe.model.Cell;
import com.tictactoe.model.GameTable;

/**
 * @author Kostya
 * @link https://github.com/kostia71/tic-tac-toe-2.git
 */
public class DataPrinterImpl {

    private final CellNumberConverter cellNumberConverter;

    public DataPrinterImpl(CellNumberConverter cellNumberConverterImpl) {
        this.cellNumberConverter = cellNumberConverterImpl;
    }

    public void printMappingTable() {
//        for (int i = 0; i < 3; i++) {
//            System.out.println("-------------");
//            for (int j = 0; j < 3; j++) {
//                System.out.print("| " + cellNumberConverter.toNumber(new Cell(i, j)) + " ");
//            }
//            System.out.println("|");
//        }
//        System.out.println("-------------");

        print((i, j) -> String.valueOf(cellNumberConverter.toNumber(new Cell(i, j))));
    }

    public void printGameTable(GameTable gameTable) {

//        for (int i = 0; i < 3; i++) {
//            System.out.println("-------------");
//            for (int j = 0; j < 3; j++) {
//                System.out.print("| " + gameTable.getSign(new Cell(i, j)) + " ");
//            }
//            System.out.println("|");
//        }
//        System.out.println("-------------");

        print((i, j) -> String.valueOf(gameTable.getSign(new Cell(i, j))));

    }

    private void print(final Lambda lambda) {
        for (int i = 0; i < 3; i++) {
            System.out.println("-------------");
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + lambda.getValue(i, j) + " ");
            }
            System.out.println("|");
        }
        System.out.println("-------------");
    }

    @FunctionalInterface
    public interface Lambda {
        String getValue(int i, int j);
    }
}
