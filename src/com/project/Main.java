package com.project;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] gameBoard = new char[3][3];
        char symbol = ' ';

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoard[i][j] = symbol;
            }
        }

        boolean player1 = true;
        boolean gameEnded = false;
        printBoard(gameBoard);
        while(!gameEnded) {

            if(player1) {
                symbol = 'X';
            } else {
                symbol = 'O';
            }

            int n = 0;
            int m = 0;
            boolean inputFound = true;
            while(inputFound) {
                System.out.print("Enter the coordinates:");
                n = sc.nextInt();
                m = sc.nextInt();
                if ( n > 3 || m > 3 ) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (n <= 3 && m <= 3) {
                    if (gameBoard[n - 1][m - 1] != ' ') {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        break;
                    }
                }  else {
                    System.out.println("You should enter numbers!");
                }
            }

            gameBoard[n-1][m-1] = symbol;
            printBoard(gameBoard);
            if(playerHasWon(gameBoard) == 'X') {
                System.out.println("X wins");
                gameEnded = true;
            } else if(playerHasWon(gameBoard) == 'O') {
                System.out.println("O wins");
                gameEnded = true;
            } else if(boardIsFull(gameBoard)){
                System.out.println("Draw");
                gameEnded = true;
            } else {
                player1 = !player1;
            }
        }
    }

    public static char playerHasWon(char[][] gameBoard) {

        //Check each row
        for(int i = 0; i < 3; i++) {
            if(gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][1] == gameBoard[i][2] && gameBoard[i][0] != ' ') {
                return gameBoard[i][0];
            }
        }

        //Check each column
        for(int j = 0; j < 3; j++) {
            if(gameBoard[0][j] == gameBoard[1][j] && gameBoard[1][j] == gameBoard[2][j] && gameBoard[0][j] != ' ') {
                return gameBoard[0][j];
            }
        }

        //Check the diagonals
        if(gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2] && gameBoard[0][0] != ' ') {
            return gameBoard[0][0];
        }
        if(gameBoard[2][0] == gameBoard[1][1] && gameBoard[1][1] ==  gameBoard[0][2] && gameBoard[2][0] != ' ') {
            return gameBoard[2][0];
        }

        //Otherwise nobody has not won yet
        return ' ';

    }

//    public static boolean isGameFinished(char[][] gameBoard) {
//        boolean xWin = false;
//        boolean oWin = false;
//        boolean activeGame = true;
//
//        while(activeGame) {
//            if (isTheWinner(gameBoard, 'X')) {
//                xWin = true;
//            } if (isTheWinner(gameBoard, 'O')) {
//                oWin = true;
//            } if (xWin && !oWin) {
//                System.out.println("X wins");
//                activeGame = false;
//                return activeGame;
//            } if (!xWin && oWin) {
//                System.out.println("O wins");
//                activeGame = false;
//                return activeGame;
//            } if (boardIsFull(gameBoard)) {
//                System.out.println("Draw");
//                activeGame = false;
//                return activeGame;
//            }
//            else activeGame = false;
//        }
//       return false;
//    }

    public static boolean boardIsFull(char[][] gameBoard) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(gameBoard[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void printBoard(char[][] gameBoard) {
        System.out.println("---------");
        System.out.println("|" + " " + gameBoard[0][0] + " " + gameBoard[0][1] + " " + gameBoard[0][2] + " " + "|");
        System.out.println("|" + " " + gameBoard[1][0] + " " + gameBoard[1][1] + " " + gameBoard[1][2] + " " + "|");
        System.out.println("|" + " " + gameBoard[2][0] + " " + gameBoard[2][1] + " " + gameBoard[2][2] + " " + "|");
        System.out.println("---------");
    }


//    private static boolean isTheWinner( char[][] gameBoard, char symbol){
//        return (gameBoard[0][0] == symbol && gameBoard[0][1] == symbol && gameBoard[0][2] == symbol) ||
//                (gameBoard[1][0] == symbol && gameBoard[1][1] == symbol && gameBoard[1][2] == symbol) ||
//                (gameBoard[2][0] == symbol && gameBoard[2][1] == symbol && gameBoard[2][2] == symbol) ||
//
//                (gameBoard[0][0] == symbol && gameBoard[1][0] == symbol && gameBoard[2][0] == symbol) ||
//                (gameBoard[0][1] == symbol && gameBoard[1][1] == symbol && gameBoard[2][1] == symbol) ||
//                (gameBoard[0][2] == symbol && gameBoard[1][2] == symbol && gameBoard[2][2] == symbol) ||
//
//                (gameBoard[0][0] == symbol && gameBoard[1][1] == symbol && gameBoard[2][2] == symbol) ||
//                (gameBoard[0][2] == symbol && gameBoard[1][1] == symbol && gameBoard[2][0] == symbol);
//    }

}
