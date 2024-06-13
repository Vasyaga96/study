package org.example;

import java.util.Scanner;

public class TicTacToe {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        boolean gameOver = false;
        char[][]field = new char[][]{
            {' ',' ',' '},
            {' ',' ',' '},
            {' ',' ',' '}
        };
        printField(field);
        int count = 0;
        char player = 'X';
        while (!gameOver){
            int line;
            int column;
            if (count == 9){
                System.out.println("Ничья");
                break;
            }
            System.out.print("Пользователь " + player + " введите строку: ");
            line = scanner.nextInt();
            checkBorderLine(line, player);
            System.out.print("Пользователь " + player + " введите столбец: ");
            column = scanner.nextInt();
            checkBorderColumn(column, player);
            while (field[line - 1][column - 1] != ' '){
                System.out.print("Это поле занято выберете другое. ");
                System.out.print("Пользователь " + player + " введите строку: ");
                line = scanner.nextInt();
                checkBorderLine(line, player);
                System.out.print("Пользователь Х введите столбец: ");
                column = scanner.nextInt();
                checkBorderColumn(column, player);
            }
            field[line - 1][column - 1] = player;
            printField(field);
            count++;
            for (int i = 0; i < 3; i++){
                if (field[i][0] == player && field[i][1] == player && field[i][2] == player){
                    System.out.println("Победил " + player);
                    gameOver = true;
                }
                if (field[0][i] == player && field[1][i] == player && field[2][i] == player){
                    System.out.println("Победил " + player);
                    gameOver = true;
                }
            }
            if ((field[0][0] == player && field[1][1] == player && field[2][2] == player) || (field[0][2] == player && field[1][1] == player && field[2][0] == player)){
                System.out.println("Победил " + player);
                gameOver = true;
            }
            if (player == 'X') {
                player = 'O';
            }else {
                player = 'X';
            }
        }
    }
    private static void printField(char[][] field){
        System.out.println("+-+-+-+");
        System.out.println("|" + field[0][0] + "|" + field[0][1] + "|" + field[0][2] + "|");
        System.out.println("+-+-+-+");
        System.out.println("|" + field[1][0] + "|" + field[1][1] + "|" + field[1][2] + "|");
        System.out.println("+-+-+-+");
        System.out.println("|" + field[2][0] + "|" + field[2][1] + "|" + field[2][2] + "|");
        System.out.println("+-+-+-+");
    }
    private static void checkBorderLine(int line, char player){
        while (line < 1 || line > 3){
            System.out.print("Попробуйте еще раз. Пользователь " + player + " введите строку: ");
            line = scanner.nextInt();
        }
    }
    private static void checkBorderColumn(int column, char player){
        while (column < 1 || column > 3){
            System.out.print("Попробуйте еще раз. Пользователь " + player + " введите столбец: ");
            column = scanner.nextInt();
        }
    }
}
