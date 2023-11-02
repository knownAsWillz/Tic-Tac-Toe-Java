package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class HardBot extends JFrame {
    // THE LOGIC BEHIND THE GAME
    // IF THE TILE IS NOT HIT IT IS 0
    // IF PLAYER HITS THE TILE, IT IS 1
    // IF BOT HITS THE TILE, IT IS 2
    int[][] game = new int[3][3];

    // CREATE TILES FOR THE GAME
    JButton col1Row1 = new JButton("-");
    JButton col1Row2 = new JButton("-");
    JButton col1Row3 = new JButton("-");
    JButton col2Row1 = new JButton("-");
    JButton col2Row2 = new JButton("-");
    JButton col2Row3 = new JButton("-");
    JButton col3Row1 = new JButton("-");
    JButton col3Row2 = new JButton("-");
    JButton col3Row3 = new JButton("-");

    // STORE THE CREATED BUTTONS IN AN ARRAY FOR LATER LOGIC
    // THIS WILL MAKE THE ACCESS FOR BUTTONS LATER EASIER
    JButton[][] buttons = {
            {col1Row1, col1Row2, col1Row3},
            {col2Row1, col2Row2, col2Row3},
            {col3Row1, col3Row2, col3Row3}
    };

    // CREATES A FRAME FOR THE GAME
    HardBot() {

        // DICTATES WHAT THE FRAME SHOULD LOOK LIKE
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 750);
        this.setResizable(false);

        // CREATES A PANEL FOR THE BUTTONS TO BE IN AND THE DISPLAY IS 3X3
        JPanel panel = new JPanel(new GridLayout(3, 3, 10, 10));

        // SETS THE SETTING FOR EACH BUTTON
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
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
        int bestMove = findBestMove(game);
        int row = bestMove / 3;
        int col = bestMove % 3;
        game[row][col] = 2;
        buttons[row][col].setText("X");
        buttons[row][col].setEnabled(false);

        // CHECKS IF THE BOT HAS WON, IF TRUE THE PLAYER WILL LOSE AND THE GAME WILL RESET
        if (opponentWin()) {
            JOptionPane.showMessageDialog(this, "You Lose!");
            resetGame();
        } else if (stalemate()) {
            JOptionPane.showMessageDialog(this, "Stalemate!");
            resetGame();
        }
    }

    private int findBestMove(int[][] board) {
        int bestScore = Integer.MIN_VALUE;
        int bestMove = -1;

        for (int i = 0; i < 9; i++) {
            int row = i / 3;
            int col = i % 3;
            if (board[row][col] == 0) {
                board[row][col] = 2; // Simulate the bot's move
                int score = minimax(board, 0, false);
                board[row][col] = 0; // Undo the move

                if (score > bestScore) {
                    bestScore = score;
                    bestMove = i;
                }
            }
        }

        return bestMove;
    }

    private int minimax(int[][] board, int depth, boolean isMaximizing) {
        int result = evaluate(board);

        if (result != 0) {
            return result;
        }

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 9; i++) {
                int row = i / 3;
                int col = i % 3;
                if (board[row][col] == 0) {
                    board[row][col] = 2; // Simulate the bot's move
                    int score = minimax(board, depth + 1, false);
                    board[row][col] = 0; // Undo the move
                    bestScore = Math.max(score, bestScore);
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 9; i++) {
                int row = i / 3;
                int col = i % 3;
                if (board[row][col] == 0) {
                    board[row][col] = 1; // Simulate the player's move
                    int score = minimax(board, depth + 1, true);
                    board[row][col] = 0; // Undo the move
                    bestScore = Math.min(score, bestScore);
                }
            }
            return bestScore;
        }
    }

    private int evaluate(int[][] board) {
        if (checkWin(board, 2)) {
            return 10;
        } else if (checkWin(board, 1)) {
            return -10;
        } else {
            return 0;
        }
    }

    private boolean checkWin(int[][] board, int player) {
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true; // Check rows
            }
        }
        for (int col = 0; col < 3; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true; // Check columns
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true; // Check diagonal (top-left to bottom-right)
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true; // Check diagonal (top-right to bottom-left)
        }
        return false;
    }

    // THE VALIDATOR IF THE PLAYER HAS WON
    boolean win() {
        return checkWin(game, 1);
    }

    // THE VALIDATOR IF THE BOT HAS WON
    boolean opponentWin() {
        return checkWin(game, 2);
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
        } else botTurn();
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
