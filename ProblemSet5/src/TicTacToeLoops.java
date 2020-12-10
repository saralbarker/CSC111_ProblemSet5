/* @file TicTacToeLoops.java
@brief Using loops to play Tic Tac Toe game with computer.
@author Sara Barker
@date 10/9/2018 */

import java.util.Random;

    import java.awt.*;
    public class TicTacToeLoops {

        public static void resetBoard() {
            StdDraw.clear();    //clear the screen of any previous drawings

            //set the board's scale
            StdDraw.setScale(-0.1, 3.1);

            StdDraw.setScale(-0.2, 3.2);

            //draw the board
            StdDraw.line(0, 0, 0, 3);
            StdDraw.line(0, 0, 3, 0);
            StdDraw.line(3, 0, 3, 3);
            StdDraw.line(0, 3, 3, 3);

            StdDraw.line(1, 0, 1, 3);
            StdDraw.line(2, 0, 2, 3);

            StdDraw.line(0, 1, 3, 1);
            StdDraw.line(0, 2, 3, 2);

        }

        public static void main(String[] args) {

            //variable declarations
            int i, j;
            int moves = 0;
            int turn = 1;  //1 is for user and 2 is for computer
            int x, y;
            int computerX = 0;
            int computerY = 0;
            Random rand = new Random();

            //you may or may not want to use these two variables
            boolean continuePlaying = true;
            boolean isThereAWinner;

            //model the board: 0 is empty, 1 is X, 2 is Oh
            int[][] board = new int[3][3];

            //resetting board when user agrees to play again
            while (continuePlaying) {
                //reset everything for the game
                resetBoard();
                isThereAWinner = false;
                moves = 0;
                for (i = 0; i < 3; i++) {
                    for (j = 0; j < 3; j++) {
                        board[i][j] = 0;
                    }
                }
                //game loop
                //establishing O's
                while (moves < 9 && isThereAWinner == false) {
                    //was the mouse pressed?
                    if (StdDraw.isMousePressed()) {
                        //yes, so get the x and y locations but keep only the integer part
                        x = (int) StdDraw.mouseX();
                        y = (int) StdDraw.mouseY();

                        if (x < 0 || x >= 3 || y < 0 || y >= 3) {
                            continue;  //bad input, go back to the while loop
                        }

                        //is the position clicked empty?
                        if (board[x][y] == 0) {

                            //it is so then place O in the screen and update board[x][y]

                            board[x][y] = 1;  //user placed O in the screen

                            //drawing of O's for each square on grid
                            //lower left
                            if (x == 0 && y == 0) {
                                StdDraw.circle(0.5, 0.5, 0.5);
                            }

                            //lower middle
                            else if (x == 1 && y == 0) {
                                StdDraw.circle(1.5, 0.5, 0.5);
                            }

                            //lower right
                            else if (x == 2 && y == 0) {
                                StdDraw.circle(2.5, 0.5, 0.5);
                            }

                            //middle left
                            else if (x == 0 && y == 1) {
                                StdDraw.circle(0.5, 1.5, 0.5);
                            }

                            //middle middle
                            else if (x == 1 && y == 1) {
                                StdDraw.circle(1.5, 1.5, 0.5);
                            }

                            //right middle
                            else if (x == 2 && y == 1) {
                                StdDraw.circle(2.5, 1.5, 0.5);
                            }

                            //top left
                            else if (x == 0 && y == 2) {
                                StdDraw.circle(0.5, 2.5, 0.5);
                            }

                            //top middle
                            else if (x == 1 && y == 2) {
                                StdDraw.circle(1.5, 2.5, 0.5);
                            }

                            //top right
                            else if (x == 2 && y == 2) {
                                StdDraw.circle(2.5, 2.5, 0.5);
                            }

                            //check if player won
                            if (isWinner(1, board)) {
                                StdDraw.text(1.5, 1.5, "You won!");
                                isThereAWinner = true;
                                break; //this allows you to immediately get out of loop!
                            }

                            //adding to variable, moves
                            moves++;


                            //make computer play
                            boolean finished = false;

                            for (i = 0; i < 3 && finished == false; i++) {
                                for (j = 0; j < 3 && finished == false; j++) {
                                    if (board[i][j] == 0) {
                                        board[i][j] = 2;
                                        computerX = i;
                                        computerY = j;
                                        finished = true;
                                    }
                                }

                            }

                            //same but for computer's usage of X's
                            //lower left
                            if (computerX == 0 && computerY == 0) {
                                StdDraw. line (0, 0, 1, 1);
                                StdDraw. line (0, 1, 1, 0);
                            }

                            //lower middle
                            else if (computerX == 1 && computerY == 0) {
                                StdDraw. line (1, 0, 2, 1);
                                StdDraw. line (1, 1, 2, 0);
                            }

                            //lower right
                            else if (computerX == 2 && computerY == 0) {
                                StdDraw. line (2, 0, 3, 1);
                                StdDraw. line (2, 1, 3, 0);
                            }

                            //middle left
                            else if (computerX == 0 && computerY == 1) {
                                StdDraw. line (0, 1, 1, 2);
                                StdDraw. line (0, 2, 1, 1);
                            }

                            //middle middle
                            else if (computerX == 1 && computerY == 1) {
                                StdDraw. line (1, 1, 2, 2);
                                StdDraw. line (1, 2, 2, 1);
                            }

                            //right middle
                            else if (computerX == 2 && computerY == 1) {
                                StdDraw. line (2, 1, 3, 2);
                                StdDraw. line (2, 2, 3, 1);
                            }

                            //top left
                            else if (computerX == 0 && computerY == 2) {
                                StdDraw. line (0, 2, 1, 3);
                                StdDraw. line (0, 3, 1, 2);
                            }

                            //top middle
                            else if (computerX == 1 && computerY == 2) {
                                StdDraw. line (1, 2, 2, 3);
                                StdDraw. line (1, 3, 2, 2);
                            }

                            //top right
                            else if (computerX == 2 && computerY == 2) {
                                StdDraw. line (2, 2, 3, 3);
                                StdDraw. line (2, 3, 3, 2);
                            }

                            //adding to variable, moves
                            moves++;

                            //checking if computer won
                            if (isWinner(2, board)) {
                                StdDraw.text(1.5, 1.5, "The computer won!");
                                isThereAWinner = true;
                            }

                        }
                    }
                }
                        //if it's a tie
                if (isThereAWinner == false) {
                    StdDraw.text(1.5, 1.5, "It's tie!");
                }
                        //ask user for input to see if new game should be generated
                StdDraw.text(1.5, 1, "Enter 'Y' for new game or 'N' to stop.");
                while (true) {
                    if (StdDraw.hasNextKeyTyped()) {
                        char d = StdDraw.nextKeyTyped();
                        if (d == 'Y') {
                            break;
                        } else if (d == 'N') {
                            continuePlaying = false;
                            break;
                        }
                    }
                }

            }
        }

        public static boolean isWinner(int player, int[][] board) {
            //ensuring that game will end after there is a winner
            //check the board for a winner

            if (board[0][0] == player && board[0][1] == player && board[0][2] == player) {
                return true;
            }
            if (board[1][0] == player && board[1][1] == player && board[1][2] == player) {
                return true;
            }
            if (board[2][0] == player && board[2][1] == player && board[2][2] == player) {
                return true;
            }
            if (board[0][0] == player && board[1][0] == player && board[2][0] == player) {
                return true;
            }
            if (board[0][1] == player && board[1][1] == player && board[2][1] == player) {
                return true;
            }
            if (board[0][2] == player && board[1][2] == player && board[2][2] == player) {
                return true;
            }
            if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
                return true;
            }
            if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
                return true;
            }
            else {
                return false;
            }
        }
}
