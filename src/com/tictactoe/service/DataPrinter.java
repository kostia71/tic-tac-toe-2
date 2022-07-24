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

package com.tictactoe.service;

import com.tictactoe.model.Cell;
import com.tictactoe.model.GameTable;

/**
 * @author Kostya
 * @link https://github.com/kostia71/tic-tac-toe-2.git
 */
public class DataPrinter {

    public void printMappingTable() {
        System.out.println("-------------");
        System.out.println("| 7 | 8 | 9 |");
        System.out.println("-------------");
        System.out.println("| 4 | 5 | 6 |");
        System.out.println("-------------");
        System.out.println("| 1 | 2 | 3 |");
        System.out.println("-------------");
    }

    public void printGameTable(GameTable gameTable) {
//        System.out.println("-------------");
//        System.out.println("| " +
//                gameTable.getSign(new Cell(0, 0)) + " | " +
//                gameTable.getSign(new Cell(0, 1)) + " | " +
//                gameTable.getSign(new Cell(0, 2)) + " | ");
//        System.out.println("-------------");
//        System.out.println("| " +
//                gameTable.getSign(new Cell(1, 0)) + " | " +
//                gameTable.getSign(new Cell(1, 1)) + " | " +
//                gameTable.getSign(new Cell(1, 2)) + " | ");
//        System.out.println("-------------");
//        System.out.println("| " +
//                gameTable.getSign(new Cell(2, 0)) + " | " +
//                gameTable.getSign(new Cell(2, 1)) + " | " +
//                gameTable.getSign(new Cell(2, 2)) + " | ");
//        System.out.println("-------------");

        for (int i = 0; i < 3; i++) {
            System.out.println("-------------");
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + gameTable.getSign(new Cell(i, j)) + " ");
            }
            System.out.println("|");
        }
        System.out.println("-------------");
    }
}
