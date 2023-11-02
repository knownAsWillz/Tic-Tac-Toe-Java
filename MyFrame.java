package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class MyFrame extends JFrame {
    // THE LOGIC BEHIND THE GAME
    // IF THE TILE IS NOT HIT, IT IS 0
    // IF PLAYER HITS THE TILE, IT IS 1
    // IF BOT HITS THE TILE, IT IS 2
    int[][] game = new int[3][3];

    // CREATE TILES FOR THE GAME
    JButton[][] buttons = new JButton[3][3];

    // CREATES A FRAME FOR THE GAME
    MyFrame() {
        // DICTATES WHAT THE FRAME SHOULD LOOK LIKE
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 750);
        this.setResizable(false);

        // CREATES A PANEL FOR THE BUTTONS TO BE IN AND THE DISPLAY IS 3X3
        JPanel panel = new JPanel(new GridLayout(3, 3, 10, 10));

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new JButton("-");
                buttons[row][col].setFocusPainted(false);
                buttons[row][col].setForeground(Color.BLACK);
                buttons[row][col].setFont(new Font("MV Boli", Font.BOLD, 50));

                final int finalRow = row;
                final int finalCol = col;

                buttons[row][col].addActionListener(e -> {
                    if (game[finalRow][finalCol] == 0) {
                        game[finalRow][finalCol] = 1;
                        buttons[finalRow][finalCol].setText("O");
                        buttons[finalRow][finalCol].setEnabled(false);
                        checker();
                    }
                });

                panel.add(buttons[row][col]);
            }
        }

        // ADDS THE PANEL TO THE FRAME
        this.add(panel);

        // CREATES A BORDER FOR THE FRAME
        Border border = new LineBorder(Color.WHITE, 10);
        this.getRootPane().setBorder(border);
        this.setLocationRelativeTo(null);
        this.setTitle("Player vs Bot");
    }

    // THIS IS WHERE THE LOGIC OF THE GAME LIES

    // THE BOT'S LOGIC
    private void botTurn() {
        boolean check = false;

        // THIS CHUNK OF CODE WILL NEVER STOP UNTIL THE ALGORITHM FINDS A ZERO IN THE "GAME" ARRAY
        while (!check) {
            int randomRow = (int) (3 * Math.random());
            int randomCol = (int) (3 * Math.random());
            if (game[randomRow][randomCol] == 0) {
                game[randomRow][randomCol] = 2;
                buttons[randomRow][randomCol].setText("X");
                buttons[randomRow][randomCol].setEnabled(false);
                check = true;
            }
        }

        // CHECKS IF THE BOT HAS WON, IF TRUE THE PLAYER WILL LOSE AND THE GAME WILL RESET
        if (opponentWin()) {
            JOptionPane.showMessageDialog(this, "You Lose!");
            resetGame();
        } else if (stalemate()) {
            JOptionPane.showMessageDialog(this, "Stalemate!");
            resetGame();
        }
    }

    // THE VALIDATOR IF THE PLAYER HAS WON
    boolean win() {
        return checkHorizontal(game) || checkVertical(game) || checkDiagonal(game);
    }

    // THE VALIDATOR IF THE BOT HAS WON
    boolean opponentWin() {
        return checkHorizontalOp(game) || checkVerticalOp(game) || checkDiagonalOp(game);
    }

    // CHECKS IF THERE IS A STALEMATE
    boolean stalemate() {
        return !win() && !opponentWin() && isBoardFull();
    }

    // MAKES THE CODE LESS REPETITIVE
    void checker() {
        if (win()) {
            JOptionPane.showMessageDialog(this, "You win!");
            resetGameBotTurn();
        } else if (stalemate()) {
            JOptionPane.showMessageDialog(this, "Stalemate!");
            resetGame();
        }

        // IF NONE OF THE PRECEDING CONDITIONS ARE TRUE, THE BOT IS VALID TO MOVE
        else botTurn();
    }

    // CHECKS IF THERE ARE TILES LEFT TO TURN
    boolean isBoardFull() {
        for (int row = 0; row < game.length; row++) {
            for (int col = 0; col < game[row].length; col++) {
                if (game[row][col] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // CHECKS FOR ANY VALID DIAGONAL PATTERN FOR THE BOT
    private boolean checkDiagonalOp(int[][] arr) {
        if (arr[0][0] == 2 && arr[1][1] == 2 && arr[2][2] == 2) return true;
        if (arr[0][2] == 2 && arr[1][1] == 2 && arr[2][0] == 2) return true;
        return false;
    }

    // CHECKS FOR ANY VALID HORIZONTAL PATTERN FOR THE BOT
    private boolean checkHorizontalOp(int[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            int count = 0;
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] == 2) count++;
            }
            if (count == 3) return true;
        }
        return false;
    }

    // CHECKS FOR ANY VALID VERTICAL PATTERN FOR THE BOT
    private boolean checkVerticalOp(int[][] arr) {
        for (int col = 0; col < arr.length; col++) {
            int count = 0;
            for (int row = 0; row < arr[col].length; row++) {
                if (arr[row][col] == 2) {
                    count++;
                }
            }
            if (count == 3) return true;
        }
        return false;
    }

    // CHECKS FOR ANY VALID HORIZONTAL PATTERN FOR THE PLAYER
    private boolean checkHorizontal(int[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            int count = 0;
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] == 1) count++;
            }
            if (count == 3) return true;
        }
        return false;
    }

    // CHECKS FOR ANY VALID VERTICAL PATTERN FOR THE PLAYER
    private boolean checkVertical(int[][] arr) {
        for (int col = 0; col < arr.length; col++) {
            int count = 0;
            for (int row = 0; row < arr[col].length; row++) {
                if (arr[row][col] == 1) {
                    count++;
                }
            }
            if (count == 3) return true;
        }
        return false;
    }

    // CHECKS FOR ANY VALID DIAGONAL PATTERN FOR THE PLAYER
    private boolean checkDiagonal(int[][] arr) {
        if (arr[0][0] == 1 && arr[1][1] == 1 && arr[2][2] == 1) return true;
        if (arr[0][2] == 1 && arr[1][1] == 1 && arr[2][0] == 1) return true;
        return false;
    }

    // RESETS THE BOARD TO THEIR DEFAULT SETTINGS / RESETS THE GAME
    private void resetGame() {
        for (int row = 0; row < game.length; row++) {
            for (int col = 0; col < game[row].length; col++) {
                game[row][col] = 0;
                buttons[row][col].setEnabled(true);
                buttons[row][col].setText("-");
            }
        }
    }

    private void resetGameBotTurn() {
        resetGame();
        botTurn();
    }
}
